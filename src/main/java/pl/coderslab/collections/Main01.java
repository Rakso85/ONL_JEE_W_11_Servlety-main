package pl.coderslab.collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main01 {

//1. W metodzie `main` utwórz listę o nazwie `elements` przechowującą elementy typu Integer.
//2. Dodaj do kolekcji 10 elementów od 10 do 19.
//3. Wypisz elementy na konsoli używając pętli for.
//4. Wypisz elementy na konsoli używając iteratora i pętli while.
//5. Wypisz na konsoli elementy używając iteratora i pętli for.
//6. Wypisz na konsoli elementy używając konstrukcji for-each.

    public static void main(String[] args) {

//        Uwaga: na tak stworzonej liście nie można dodawać/usuwać elementów.
//        List<Integer> elements = List.of(10,11,12,13,14,15,16,17,18,19);

        List<Integer> elements = new ArrayList<>();
        elements.add(10);
        elements.add(11);
        elements.add(12);
        elements.add(13);
        elements.add(14);
        elements.add(15);
        elements.add(16);
        elements.add(17);
        elements.add(18);
        elements.add(19);

        for(int i = 0; i < elements.size(); i++) {
            Integer val = elements.get(i);
            System.out.println(val);
        }

        Iterator<Integer> iterator = elements.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            System.out.println(val);
        }

        for(Integer val : elements) {
            System.out.println(val);
        }

    }
}

