package pl.coderslab.setmap;

import java.util.*;

public class Main02 {

    public static void main(String[] args) {
        int points = 0;
        Map<String, String> antMan = getMap();
        Scanner scanner = new Scanner(System.in);

        Set<String> words = antMan.keySet();

//        Lista z wymieszanymi kluczami:
//        Set<String> keys = antMan.keySet();
//        List<String> words = new ArrayList<>(keys);
//        Collections.shuffle(words);

//        Utworzenie zbioru na podstawie listy
//        Set<Integer> numbers = new HashSet<>(List.of(1,2,3,4,4,3,2,1));

        for (String word : words) {
            System.out.print("Przeciwieństwo do '" + word + "', to ... ");
            String answer = scanner.nextLine();
            String opposite = antMan.get(word);
            if (answer.equalsIgnoreCase(opposite)) {
                points++;
            }
        }

//        Rozwiązanie alternatywne z wykorzystaniem wpisów (pozycji w mapie)
//        Set<Map.Entry<String, String>> entries = antMan.entrySet();
//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println("Przeciwieństwo do '" + entry.getKey() + "', to ... ");
//            String answer = scanner.nextLine();
//            String opposite = entry.getValue();
//            if (answer.equalsIgnoreCase(opposite)) {
//                points++;
//            }
//        }

        System.out.println("Poprawnych odpowiedzi: " + points);
    }

    public static Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("czarny", "biały");
        map.put("duży", "mały");
        map.put("drogi", "tani");
        map.put("Java", "JavaScript");
        map.put("Tusk", "Kaczyński");
        return map;
    }
}