package com.dscfgos.patterns.behavioral.iterator;

public class CustomCollection<T> implements Aggregate<T> {

    private final T[] items;

    public CustomCollection(T[] items) {
        this.items = items;
    }

    @Override
    public Iterator<T> getIterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {
        private int index;

        @Override
        public boolean hasNext() {
            return (items != null && index < items.length);
        }

        @Override
        public T next() {
            return this.hasNext() ? items[index++] : null;
        }
    }
}
