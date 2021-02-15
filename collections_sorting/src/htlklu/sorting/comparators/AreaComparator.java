package htlklu.sorting.comparators;

import htlklu.sorting.Country;

import java.util.Comparator;

public class AreaComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o2.getArea() - o1.getArea();
    }
}
