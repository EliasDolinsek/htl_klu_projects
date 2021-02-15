package htlklu.sorting;

import htlklu.sorting.comparators.AreaComparator;
import htlklu.sorting.comparators.PopulationComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Österreich", "Wien", 8504850, 838790));
        countries.add(new Country("Guatemala", "Ligonha", 3311, 8387));
        countries.add(new Country("India", "Faizabad", 153047, 83877));
        countries.add(new Country("China", "Hulan Ergi", 277672, 83870));
        countries.add(new Country("Mauritania", "Kiffa", 73930, 8387912));
        countries.add(new Country("Deutschland", "Berlin", 3769000, 838));
        countries.add(new Country("Italien", "Rom", 2873000, 83875));

        Collections.sort(countries);
        printCountries(countries);

        System.out.println("\n");

        countries.sort(new PopulationComparator());
        printCountries(countries);

        System.out.println("\n");

        countries.sort(new AreaComparator());
        printCountries(countries);

        System.out.println("\n");

        Country[] countriesArray = countries.toArray(new Country[0]);
        Arrays.sort(countriesArray, new PopulationComparator());
        System.out.println(Arrays.toString(countriesArray));
    }

    private static void printCountries(ArrayList<Country> countries) {
        for (Country country : countries) {
            System.out.println(country);
        }
    }
}
