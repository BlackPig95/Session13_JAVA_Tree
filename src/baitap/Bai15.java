package baitap;

import java.util.*;

public class Bai15
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> treeMap = new TreeMap<>();
        final int arraySize = 10;
        for (int i = 0; i < arraySize; i++)//Khởi tạo map với các số ngẫu nhiên làm key value
        {   //Tạo các key value pair với key tăng dần
            treeMap.put(i, Utility.random.nextInt(100));
        }
        System.out.println(treeMap);
        System.out.println(treeMap.remove(3));//Xóa phần tử có key số 3
        System.out.println(treeMap);
    }
}
