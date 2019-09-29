package com.javarush.task.task37.task3701;

import java.util.ArrayList;
import java.util.Iterator;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator implements Iterator<T> {
        private Iterator<T> superIterator = Solution.super.iterator();

        @Override
        public boolean hasNext() {
            if (size() == 0) {
                return false;
            }

            if ( ! superIterator.hasNext()) {
                superIterator = Solution.super.iterator();
            }

            return true;
        }

        @Override
        public T next() {
            return superIterator.next();
        }

        @Override
        public void remove() {
            superIterator.remove();
        }
    }
}
