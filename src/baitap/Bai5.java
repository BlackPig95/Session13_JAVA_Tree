package baitap;

import java.util.*;

public class Bai5
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> hashMap = new HashMap<>();
        final int arraySize = 10;
        for (int i = 0; i < arraySize; i++)//Khởi tạo map với các số ngẫu nhiên làm key value
        {
            hashMap.put(Utility.random.nextInt(1, 1000), Utility.random.nextInt(1, 100));
        }
        System.out.println(hashMap);
        ArrayList<Map.Entry<Integer, Integer>> orderArray = new ArrayList<>(hashMap.entrySet());
        Collections.sort(orderArray, (element1, element2) -> element1.getValue().compareTo(element2.getValue()));
        System.out.println(orderArray);
    }
}
