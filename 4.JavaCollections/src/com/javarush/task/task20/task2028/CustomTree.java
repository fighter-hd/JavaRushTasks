package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Map<Integer, List<Entry<String>>>  tree = new TreeMap<>();
    Entry<String> root;
    private int size;

    public CustomTree() {
        root = new Entry<>("theRoot");
    }

    @Override
    public boolean add(String s) {
        if (root.isAvailableToAddChildren()) {
            addFirstDeepElements(s);

        } else {
            Entry<String> newElement = new Entry<>(s);
            int deep = 2;

            while (true) {
                if (isAvailableToAddOnCurrentDeep(deep)) {
                    List<Entry<String>> currentParentsDeep = tree.get(deep - 1);

                    for (Entry<String> currentParent : currentParentsDeep) {
                        if (currentParent.isAvailableToAddChildren()) {
                            List<Entry<String>> childDeepList = tree.get(1);

                            if (childDeepList == null) {
                                childDeepList = new ArrayList<>();
                                tree.put(deep, childDeepList);
                            }

                            if (currentParent.availableToAddLeftChildren) {
                                addLeftChild(currentParent, newElement, childDeepList);

                            } else {
                                addRightChild(currentParent, newElement, childDeepList);
                            }

                            break;
                        }
                    }

                    break;

                } else {
                    deep++;
                }
            }
        }

        size++;

        return true;
    }

    private void addFirstDeepElements(String s) {
        List<Entry<String>> firstDeepList = tree.computeIfAbsent(1, k -> new ArrayList<>());

        Entry<String> newElement = new Entry<>(s);

        if (root.availableToAddLeftChildren) {
            addLeftChild(root, newElement, firstDeepList);

        } else {
            addRightChild(root, newElement, firstDeepList);
        }
    }

    private void addLeftChild(Entry<String> parent, Entry<String> child, List<Entry<String>> childDeepList) {
        child.parent = parent;
        parent.leftChild = child;
        parent.availableToAddLeftChildren = false;
        childDeepList.add(child);
    }

    private void addRightChild (Entry<String> parent, Entry<String> child, List<Entry<String>> childDeepList) {
        child.parent = parent;
        parent.rightChild = child;
        parent.availableToAddRightChildren = false;
        childDeepList.add(child);
    }

    private boolean isAvailableToAddOnCurrentDeep(int deep) {
        List<Entry<String>> currentDeepList = tree.get(deep - 1);

        for (Entry<String> element : currentDeepList) {
            if (element.isAvailableToAddChildren()) {
                return true;
            }
        }

        return false;
    }

    public String getParent(String s) {
        Entry<String> element = getElement(s, root);

        if (element != null) {
            return element.parent.elementName;
        } else {
            return null;
        }
    }

    private Entry<String> getElement(String checkedName, Entry<String> currentEntry) {
        if (currentEntry.elementName.equals(checkedName)) {
            return currentEntry;
        }

        Entry<String> childElement = null;

        if (currentEntry.leftChild != null) {
            childElement = getElement(checkedName, currentEntry.leftChild);
        }

        if (childElement == null && currentEntry.rightChild != null) {
            childElement = getElement(checkedName, currentEntry.rightChild);
        }

        return childElement;
    }

    @Override
    public int size() {
        return size;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        Entry<T> leftChild;
        Entry<T> rightChild;
        Entry<T> parent;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        @Override
        public String toString() {
            return elementName;
        }
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
