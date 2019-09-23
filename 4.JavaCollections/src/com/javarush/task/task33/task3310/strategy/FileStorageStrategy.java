package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final long DEFAULT_BUCKET_SIZE_LIMIT = 1000L;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    int size;
    private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT;
    long maxBucketSize;

    public int hash(Long k) {
        int h;
        return (k == null) ? 0 : (h = k.hashCode()) ^ (h >>> 16);
    }

    public int indexFor(int hash, int length) {
        return (length - 1) & hash;
    }

    public Entry getEntry(Long key) {
        int hash = hash(key);
        FileBucket bucket = this.table[indexFor(hash, this.table.length)];

        for (Entry e = bucket.getEntry(); e != null ; e = e.next) {
            Long k;

            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                return e;
            }
        }

        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        this.table = newTable;

        for (FileBucket bucket : table) {
            bucket.remove();
        }
    }

    public void transfer(FileBucket[] newTable) {
        FileBucket[] src = this.table;
        int newCapacity = newTable.length;

        for (int j = 0; j < src.length; j++) {
            FileBucket oldTableBucket = src[j];
            Entry e = oldTableBucket.getEntry();

            if (e != null) {
                src[j] = null;

                do {
                    Entry next = e.next;
                    int i = indexFor(e.hash, newCapacity);
                    FileBucket newTableBucket;

                    if (newTable[i] == null) {
                        newTableBucket = new FileBucket();
                        newTable[i] = newTableBucket;
                    } else {
                        newTableBucket = newTable[i];
                    }

                    e.next = newTableBucket.getEntry();
                    newTableBucket.putEntry(e);

                    e = next;

                } while (e != null);
            }
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        createEntry(hash, key, value, bucketIndex);

        FileBucket bucket = this.table[bucketIndex];

        if (bucket.getFileSize() > bucketSizeLimit) {
            resize(this.table.length * 2);
        }
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        FileBucket bucket = this.table[bucketIndex];

        if (bucket == null) {
            bucket = new FileBucket();
            this.table[bucketIndex] = bucket;
        }

        Entry e = bucket.getEntry();
        Entry newEntry = new Entry(hash, key, value, e);
        bucket.putEntry(newEntry);
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < this.table.length; i++) {
            FileBucket bucket = this.table[i];

            if (bucket == null) {
                continue;
            }

            for (Entry entry = bucket.getEntry(); entry != null; entry = entry.next) {
                if (entry.getValue().equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, this.table.length);

        FileBucket bucket = this.table[index];

        if (bucket == null) {
            bucket = new FileBucket();
            this.table[index] = bucket;
        }

        for (Entry entry = bucket.getEntry(); entry != null; entry = entry.next) {
            Long k;

            if (entry.hash == hash && ((k = entry.key) == key || key.equals(k))) {
                entry.value = value;
                return;
            }
        }

        addEntry(hash, key, value, index);
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < this.table.length; i++) {
            for (Entry e = this.table[i].getEntry(); e != null; e = e.next) {
                if (e.getValue().equals(value)) {
                    return e.getKey();
                }
            }
        }

        return null;
    }

    @Override
    public String getValue(Long key) {
        return getEntry(key).getValue();
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }
}
