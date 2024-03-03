import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdditerator.IteratorCircularList;
import tdditerator.IteratorCircularListImpl;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IteratorCircularListTest {

    private IteratorCircularList list;

    @BeforeEach
    void beforeEach() {
        list = new IteratorCircularListImpl();
    }

    @Test
    void testEmptyForward() {
        assertFalse(list.forwardIterator().hasNext());
    }

    @Test
    void testEmptyBackward() {
        assertFalse(list.backwardIterator().hasNext());
    }

    private void populateList(int... elements) {
        for (int elem : elements)
            list.add(elem);
    }

    private void testSequenceOnIterator(final Iterator<Integer> iterator, final List<Integer> expectedSequence) {
        for (final int expected : expectedSequence) {
            assertEquals(expected, iterator.next());
        }
    }

    @Test
    void testForward() {
        populateList(1, 2);
        testSequenceOnIterator(list.forwardIterator(), List.of(1, 2, 1));
    }

    @Test
    void testPrevious() {
        populateList(1, 2);
        testSequenceOnIterator(list.backwardIterator(), List.of(2, 1, 2));
    }
}
