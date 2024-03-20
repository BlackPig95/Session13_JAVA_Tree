package baitap;

import java.util.HashMap;
import java.util.Map;

public class Bai7
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
        Map<Integer, Integer> hashMapCopy = new HashMap<>();
        hashMapCopy.putAll(hashMap);
        System.out.println("------------After Copy-----------------");
        System.out.println(hashMapCopy);

    }
}
