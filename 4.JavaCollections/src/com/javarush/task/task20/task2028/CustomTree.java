package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Map<Integer, List<Entry<String>>> tree = new TreeMap<>();
    Entry<String> root;
    private int size;

    public CustomTree() {
        root = new Entry<>("theRoot");
    }

    @Override
    public boolean add(String s) {
        if (noAtLeastOneAvailableToAdd()) {
            refreshAvailableFields();
        }

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
                            List<Entry<String>> childDeepList = tree.get(deep);

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

    private boolean noAtLeastOneAvailableToAdd() {
        for (int deep = tree.size() + 1; deep > 0; deep--) {
            if (isAvailableToAddOnCurrentDeep(deep)) {
                return false;
            }
        }

        return true;
    }

    private void refreshAvailableFields() {
            int deep = tree.size();
            List<Entry<String>> currentDeepList = checkDeepList(deep);


            if (currentDeepList != null) {

                for (Entry<String> element : currentDeepList) {
                    if (element.leftChild == null) {
                        element.availableToAddLeftChildren = true;
                    }

                    if (element.rightChild == null) {
                        element.availableToAddRightChildren = true;
                    }
                }

            }
    }

    private List<Entry<String>> checkDeepList(int deep) {
        List<Entry<String>> currentDeepList = tree.get(deep);

        if (currentDeepList != null && currentDeepList.isEmpty()) {
            tree.remove(deep);
            currentDeepList = checkDeepList(deep - 1);
        }

        return currentDeepList;
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

        if (currentDeepList != null) {
            for (Entry<String> element : currentDeepList) {
                if (element.isAvailableToAddChildren()) {
                    return true;
                }
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

    @Override
    public boolean remove(Object o) {
        if ( ! (o instanceof String)) {
            throw new UnsupportedOperationException();
        }

        Entry<String> element = getElement((String) o, root);

        if (element == null) {
            return false;
        }

        for (int deep = 1; deep <= tree.size(); deep++) {
            List<Entry<String>> currentDeepElements = tree.get(deep);

            if (currentDeepElements.contains(element)) {
                removeElement(element, deep);
                return true;
            }
        }

        return false;
    }

    private void removeElement(Entry<String> removeElement, int deep) {
        List<Entry<String>> currentDeepList = tree.get(deep);

        Entry<String> leftChild = removeElement.leftChild;
        Entry<String> rightChild = removeElement.rightChild;

        if (leftChild != null) {
            removeElement.leftChild = null;
            removeElement(leftChild, deep + 1);
        }

        if (rightChild != null) {
            removeElement.rightChild = null;
            removeElement(rightChild, deep + 1);
        }

        removeInParent(removeElement);

        currentDeepList.remove(removeElement);
        size--;
    }

    private void removeInParent(Entry<String> removeElement) {
        Entry<String> parent = removeElement.parent;

        if (parent.leftChild == removeElement) {
            parent.leftChild = null;
        } else {
            parent.rightChild = null;
        }
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

    void treePrint() {
        for (Map.Entry<Integer, List<Entry<String>>> entry : tree.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (Entry<String> stringEntry : entry.getValue()) {
                System.out.print(stringEntry + ", ");
            }

            System.out.println();
        }
    }
}