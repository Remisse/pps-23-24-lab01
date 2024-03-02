package tddfilter;

import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FilteredCircularListImpl implements FilteredCircularList {
    private final CircularList list = new CircularListImpl();

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
    public Optional<Integer> next() {
        return list.next();
    }

    @Override
    public Optional<Integer> previous() {
        return list.previous();
    }

    @Override
    public void reset() {
        list.reset();
    }

    @Override
    public Optional<Integer> filteredNext(Predicate<Integer> filter) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> list.next().orElseThrow())
                .filter(filter)
                .findFirst();
    }
}
