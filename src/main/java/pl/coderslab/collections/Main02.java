package pl.coderslab.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main02 {

    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);

        System.out.println(nums);
        removeDivider(nums, 2);
        System.out.println(nums);
    }

    public static void removeDivider(List<Integer> integers, int divider) {
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer val = iterator.next();
            if (val % divider == 0) {
                iterator.remove();
            }
        }

//        for (int i = 0; i < integers.size();) {
//            Integer val = integers.get(i);
//            if (val % divider == 0) {
//                integers.remove(i);
//            } else {
//                i++;
//            }
//        }
    }
}