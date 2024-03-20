package baitap;

import java.util.HashMap;
import java.util.Map;

public class Bai9
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> hashMap = new HashMap<>();
        final int arraySize = 10;
        for (int i = 0; i < arraySize; i++)//Khởi tạo map với các số ngẫu nhiên làm key value
        {                           //Bound đến 10 để tăng tỉ lệ xuất hiện key giống với key cần tìm
            hashMap.put(Utility.random.nextInt(1, 10), Utility.random.nextInt(1, 100));
        }
        System.out.println(hashMap);
        System.out.println(hashMap.containsKey(3));//Một vài giá trị ngẫu nhiên để kiểm tra
        System.out.println(hashMap.containsKey(7));
        System.out.println(hashMap.containsKey(25));
        System.out.println(hashMap.containsKey(5));
    }
}
