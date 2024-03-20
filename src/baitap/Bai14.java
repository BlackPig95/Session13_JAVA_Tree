package baitap;

import java.util.*;

public class Bai14
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());//Comparator để
        final int arraySize = 20;                                               //set order cho TreeMap
        for (int i = 0; i < arraySize; i++)//Khởi tạo map với các số ngẫu nhiên làm key value
        {
            treeMap.put(Utility.random.nextInt(1, 10), Utility.random.nextInt(1, 100));
        }
        System.out.println(treeMap);
    }
}
