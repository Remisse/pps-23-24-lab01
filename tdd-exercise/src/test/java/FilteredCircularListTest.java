import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tddfilter.FilteredCircularList;
import tddfilter.FilteredCircularListImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FilteredCircularListTest {

    private FilteredCircularList list;

    @BeforeEach
    void beforeEach() {
        list = new FilteredCircularListImpl();
    }

    @Test
    void testFilterEmptyList() {
        assertEquals(Optional.empty(), list.filteredNext(elem -> elem == 1));
    }

    private void populateList(int... elements) {
        for (int i : elements)
            list.add(i);
    }

    @Test
    void testFilterSuccess() {
        populateList(1, 2, 3);
        assertEquals(Optional.of(2), list.filteredNext(elem -> elem == 2));
    }

    @Test
    void testFilterFail() {
        populateList(1, 2, 3);
        assertEquals(Optional.empty(), list.filteredNext(elem -> elem == 4));
    }
}
