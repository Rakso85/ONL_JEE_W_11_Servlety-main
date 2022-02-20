package pl.coderslab.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main04 {

    public static void main(String[] args) {
        List<City> cities = Main03.initialize();
        System.out.println(cities);
        List<City> reversedCities = reverse(cities);
        System.out.println(reversedCities);
    }

    public static List<City> reverse(List<City> cities) {
        List<City> reversed = new ArrayList<>();
        ListIterator<City> listIterator = cities.listIterator(cities.size());
        while (listIterator.hasPrevious()) {
            reversed.add(listIterator.previous());
        }
        return reversed;
    }
}
