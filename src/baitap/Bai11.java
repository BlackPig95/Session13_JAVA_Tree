package baitap;

import java.util.ArrayList;
import java.util.TreeMap;

public class Bai11
{
    public static void main(String[] args)
    {
        ArrayList<Integer> initialArray = new ArrayList<>();
        final int arraySize = 20;
        for (int i = 0; i < arraySize; i++)//Khởi tạo mảng với các số ngẫu nhiên
        {
            initialArray.add(Utility.random.nextInt(1, 100));
        }
        System.out.println(initialArray);//Mảng ban đầu

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < arraySize; i++)
        {
            treeMap.put(initialArray.get(i), 0);//Gán các key vào treemap để được sắp xếp theo natural order
        }
        System.out.println(treeMap);
    }
}
