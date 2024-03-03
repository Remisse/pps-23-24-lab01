package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {
    private final List<Integer> list;
    private int currentIndex;

    public CircularListImpl() {
        list = new ArrayList<>();
        currentIndex = -1;
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

    private Optional<Integer> getCurrentItem() {
        if (isEmpty())
            return Optional.empty();

        return Optional.of(list.get(currentIndex));
    }

    private int wraparoundIndex(final int newIndex) {
        if (newIndex >= list.size())
            return 0;
        if (newIndex < 0)
            return list.size() - 1;

        return newIndex;
    }

    @Override
    public Optional<Integer> next() {
        currentIndex = wraparoundIndex(currentIndex + 1);
        return getCurrentItem();
    }

    @Override
    public Optional<Integer> previous() {
        currentIndex = wraparoundIndex(currentIndex - 1);
        return getCurrentItem();
    }

    @Override
    public void reset() {
        list.clear();
    }
}
