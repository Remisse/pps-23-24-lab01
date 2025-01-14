import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.CircularList;
import tdd.CircularListImpl;

import java.util.List;

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
    }

    @Test
    void testNextIsEmpty() {
        assertTrue(list.next().isEmpty());
    }

    @Test
    void testPreviousIsEmpty() {
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
        list.reset();
        assertTrue(list.isEmpty());
    }

    @Test
    void testNext() {
        list.add(1);
        assertEquals(1, list.next().orElseThrow());
    }

    @Test
    void testPrevious() {
        list.add(1);
        assertEquals(1, list.previous().orElseThrow());
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
