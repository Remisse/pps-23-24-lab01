import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The test suite for testing the CircularList implementation
 */
class CircularListTest {

    private CircularList list;

    @BeforeEach
    void beforeEach() {
        list = new CircularListImpl();
    }

    @Test
    void testEmpty() {
        assertTrue(list.isEmpty());
        assertTrue(list.next().isEmpty());
        assertTrue(list.previous().isEmpty());
    }

    @Test
    void testAdd() {
        final var testElements = List.of(1, 2, 3);
        for (int i : testElements) {
            list.add(i);
            assertEquals(i, list.next().orElseThrow());
        }

        assertEquals(testElements.size(), list.size());
    }

    @Test
    void testReset() {
        list.add(1);
        assertEquals(1, list.size());
        list.reset();
        assertTrue(list.isEmpty());
    }

    @Test
    void testNext() {
        list.add(1);
        final Optional<Integer> next = list.next();
        assertEquals(1, next.orElseThrow());
    }

    @Test
    void testPrevious() {
        list.add(1);
        final Optional<Integer> previous = list.previous();
        assertEquals(1, previous.orElseThrow());
    }

    @Test
    void testBackAndForth() {
        for (int elem : List.of(1, 2, 3))
            list.add(elem);

        assertEquals(1, list.next().orElseThrow());
        assertEquals(2, list.next().orElseThrow());

        assertEquals(1, list.previous().orElseThrow());
        assertEquals(3, list.previous().orElseThrow());
    }
}
