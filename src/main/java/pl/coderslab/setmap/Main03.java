package pl.coderslab.setmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main03 {

    public static void main(String[] args) {
        List<Country> countries = initialize();
        Map<String, Country> capitalToCountryMap = getMap(countries);
        for (String capital : capitalToCountryMap.keySet()) {
            Country country = capitalToCountryMap.get(capital);
            System.out.printf("%s - %s%n", capital, country.getName());
        }
    }

    public static List<Country> initialize() {
        List<Country> list = new ArrayList<>();
        list.add(new Country("Polska", "Warszawa"));
        list.add(new Country("Niemcy", "Berlin"));
        list.add(new Country("Grecja", "Ateny"));
        list.add(new Country("Rosja", "Moskwa"));
        list.add(new Country("Francja", "Paryż"));
        return list;
    }

    public static Map<String, Country> getMap(List<Country> countries) {
        Map<String, Country> map = new HashMap<>();
        for (Country country : countries) {
            map.put(country.getCapital(), country);
        }
        return map;
    }
}




