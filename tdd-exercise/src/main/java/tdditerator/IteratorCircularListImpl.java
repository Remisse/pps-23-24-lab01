package tdditerator;

import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.Iterator;
import java.util.stream.IntStream;

public class IteratorCircularListImpl implements IteratorCircularList {
    private final CircularList list;

    public IteratorCircularListImpl() {
        list = new CircularListImpl();
    }

    @Override
    public void add(int element) {
        list.add(element);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        if (isEmpty())
            return IntStream.empty().iterator();

        return IntStream.generate(() -> list.next().orElseThrow())
                .iterator();
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        if (isEmpty())
            return IntStream.empty().iterator();

        return IntStream.generate(() -> list.previous().orElseThrow())
                .iterator();
    }
}
