package pl.coderslab.setmap;

import java.util.*;

public class Main01 {

    public static void main(String[] args) {
        int counter = 0;
//        Nieustalona kolejność, unikalność, błyskawiczne pobieranie po kluczu
        Set<String> strings = new HashSet<>();
//        Ustalona kolejność wstawiania, unikalność, błyskawiczne pobieranie po kluczu, wolniejsze wstawianie/usuwanie
//        Set<String> strings = new LinkedHashSet<>();
//        Kolejność zgodna z porządkiem sortowania (naturalny dla liczb i tekstów), unikalność, szybkie (ale nie błyskawiczne) pobieranie po kluczu
//        Set<String> strings = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        String str;
        while (!(str = scanner.nextLine()).equals("exit")) {
            counter++;
            strings.add(str);

//            boolean added = strings.add(str);
//            System.out.println("Czy dodano? " + added);
        }

        System.out.printf("Podanych napisów: %d, rozmiar kolekcji: %d%n", counter, strings.size());
        System.out.println(strings);
    }
}
