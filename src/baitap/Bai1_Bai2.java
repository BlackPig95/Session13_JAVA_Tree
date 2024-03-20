package baitap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bai1_Bai2
{
    public static void main(String[] args)
    {
        ArrayList<Integer> initialArray = new ArrayList<>();
        final int arraySize = 20;
        for (int i = 0; i < arraySize; i++)//Khởi tạo mảng với các số ngẫu nhiên
        {
            initialArray.add(Utility.random.nextInt(1, 10));
        }
        System.out.println(initialArray);//Mảng ban đầu
        Map<Integer, Integer> countMap = new HashMap();
        for (Integer number : initialArray)
        {
            if (!countMap.containsKey(number))//Nếu số này chưa từng gặp
                countMap.put(number, 1);    //thì thêm số này làm key, value là 1
            else countMap.put(number, countMap.get(number) + 1);//Nếu số đã xuất hiện, set lại key với value +1
        }
        System.out.println(countMap);//Bài 1
        //Bài 2
        Set<Map.Entry<Integer, Integer>> setOnce = countMap.entrySet();//Tạo set entry để duyệt key value pair
        for (Map.Entry<Integer, Integer> entry : setOnce)
        {
            if (entry.getValue() == 1)//Value = 1 => Số này xuất hiện 1 lần
            {
                System.out.println(entry.getKey());//=> In ra key tương ứng
            }
        }
    }
}
