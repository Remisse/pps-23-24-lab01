package tdditerator;

import java.util.Iterator;

public interface IteratorCircularList {
    /**
     * Adds an element to the list, namely, after the last inserted one.
     * @param element the element to be added to the list
     */
    void add(final int element);

    /**
     * Provides the current size of the list
     * @return the size of the list
     */
    int size();

    /**
     * Checks if the list is empty
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Provides an iterator that yields elements starting from the first and going forward.
     * @return an iterator
     */
    Iterator<Integer> forwardIterator();

    /**
     * Provides an iterator that yields elements starting from the last and going backwards.
     * @return an iterator
     */
    Iterator<Integer> backwardIterator();
}
