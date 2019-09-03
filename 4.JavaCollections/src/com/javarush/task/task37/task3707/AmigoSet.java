package com.javarush.task.task37.task3707;

import java.io.*;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        int capacity = (int) Math.max(16, collection.size()/.75f + 1);
        this.map = new HashMap<>(capacity);

        for (E e : collection) {
            map.put(e, PRESENT);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override
    public int size() {
        return this.map.size();
    }

    @Override
    public boolean contains(Object o) {
        return this.map.containsKey(o);
    }

    @Override
    public boolean add(E e) {
        return this.map.put(e, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return this.map.remove(o) == o;
    }

    @Override
    public Iterator<E> iterator() {
        return this.map.keySet().iterator();
    }

    @Override
    public void clear() {
        this.map.clear();
    }

    @Override
    public Object clone() throws InternalError {
        try {
            AmigoSet<E> cloneSet = (AmigoSet<E>) super.clone();
            cloneSet.map = (HashMap<E, Object>) this.map.clone();
            return cloneSet;
            
        } catch (Exception e) {
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();

        Set<E> keySet = this.map.keySet();

        Object[] array = keySet.toArray();
        outputStream.writeObject(array);

        Object loadFactor = HashMapReflectionHelper.callHiddenMethod(this.map, "loadFactor");
        outputStream.writeObject(loadFactor);

        Object capacity = HashMapReflectionHelper.callHiddenMethod(this.map, "capacity");
        outputStream.writeObject(capacity);
    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();

        Object[] keysArray = (Object[]) inputStream.readObject();
        float loadFactor = (float) inputStream.readObject();
        int capacity = (int) inputStream.readObject();

        this.map = new HashMap<>(capacity, loadFactor);

        for (Object e : keysArray) {
            this.map.put((E) e, PRESENT);
        }
    }

//    public static void main(String[] args) {
//        AmigoSet<Integer> amigoSet = new AmigoSet<>();
//        amigoSet.add(0);
//        amigoSet.add(1);
//        amigoSet.add(2);
//        amigoSet.add(3);
//        amigoSet.add(4);
//        System.out.println("Before: " + amigoSet.size());
//
//        AmigoSet<Integer> amigoSetCopy = null;
//        File file = new File("C:\\Users\\Gans\\Desktop\\Java_instructions\\For_Tests\\SerializableTest.out");
//
//        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
//             ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
//
//            out.writeObject(amigoSet);
//            amigoSetCopy = (AmigoSet<Integer>) in.readObject();
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("After: " + amigoSet.size());
//        System.out.println(amigoSet.hashCode());
//        System.out.println(amigoSetCopy.hashCode());
//    }
}
