package ru.job4j.set;

import ru.job4j.collection.SimpleArrayList;

import java.util.Iterator;

public class SimpleArraySet<T> implements SimpleSet<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(0);

    @Override
    public boolean add(T value) {
        if (!contains(value)) {
            set.add(value);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T value) {
        for(T element : set) {
        if (value == null && element == null) {
            return true;
        }
            if (value != null && value.equals(element)) {
        return true;
    }
        }
            return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}