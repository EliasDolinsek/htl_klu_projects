package htlklu.sorting;

public class Country implements Comparable<Country> {

    final String name, capital;
    final int population, area;

    public Country(String name, String capital, int population, int area) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public int getArea() {
        return area;
    }
    
    public Object[] toArray() {
    	return new Object[]{name, capital, new Integer(population), new Integer(area)};
    }

    @Override
    public int compareTo(Country o) {
        return name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "htlklu.sorting.Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
