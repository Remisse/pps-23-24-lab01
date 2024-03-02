package tdditerator;

import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.Iterator;
import java.util.function.IntSupplier;
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

    private Iterator<Integer> getIterator(IntSupplier supplier) {
        if (isEmpty())
            return IntStream.empty().iterator();

        return IntStream.generate(supplier)
                .iterator();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        return getIterator(() -> list.next().orElseThrow());
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        return getIterator(() -> list.previous().orElseThrow());
    }
}
