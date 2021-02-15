package htlklu.sorting.comparators;

import htlklu.sorting.Country;

import java.util.Comparator;

public class PopulationComparator implements Comparator<Country> {
    @Override
    public int compare(Country o1, Country o2) {
        return o2.getPopulation() - o1.getPopulation();
    }
}
