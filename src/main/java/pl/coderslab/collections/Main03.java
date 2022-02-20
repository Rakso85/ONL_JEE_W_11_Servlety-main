package pl.coderslab.collections;
import java.util.ArrayList;
import java.util.List;

public class Main03 {

    public static void main(String[] args) {
        List<City> cities = initialize();
        System.out.println(cities);
        List<City> cities2and3 = sublist(cities, 2, 4);
        System.out.println(cities2and3);
        List<City> cities2and3_2 = sublist2(cities, 2, 4);
        System.out.println(cities2and3_2);
    }

    public static List<City> initialize() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Wrocław", 600_000));
        cities.add(new City("Kraków", 1_000_000));
        cities.add(new City("Warszawa", 2_000_000));
        cities.add(new City("Gdańsk", 600_000));
        cities.add(new City("Poznań", 600_000));
        return cities;
    }

    public static List<City> sublist(List<City> from, int start, int end) {
        if (start < 0 || start >= from.size()) {
            throw new IllegalArgumentException("Start index must be within list size");
        }
        if (end > from.size()) {
            throw new IllegalArgumentException("End index must be less than size");
        }
        if (end <= start) {
            throw new IllegalArgumentException("End index must be less than start index");
        }
        List<City> to = new ArrayList<>();
        for (int i = start; i < end; i++) {
            to.add(from.get(i));
        }
        return to;
    }

    public static List<City> sublist2(List<City> from, int start, int end) {
        return from.subList(start, end);
    }
}
