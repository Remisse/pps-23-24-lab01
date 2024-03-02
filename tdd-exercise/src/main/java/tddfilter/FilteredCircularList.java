package tddfilter;

import tdd.CircularList;

import java.util.Optional;
import java.util.function.Predicate;

public interface FilteredCircularList extends CircularList {
    /**
     * Provides the next element in the list that satisfies a user-defined condition.
     * @param filter condition to test the list elements with
     * @return an optional integer
     */
    Optional<Integer> filteredNext(Predicate<Integer> filter);
}
