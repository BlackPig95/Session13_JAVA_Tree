package baitap;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Bai12
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
        System.out.println("Nhập phần tử lớn thứ n muốn tìm");
        int n = Integer.parseInt(Utility.scanner.nextLine());
        System.out.println("Phần tử lớn thứ " + n + " trong map là: ");
        System.out.println(findKeyOrder(treeMap, n));
    }

    //    private static int findKeyOrder(TreeMap<Integer, Integer> treeMap, int n)
//    {
//        for (int i = 1; i < n; i++)//Bỏ bớt n-1 phần tử có key là lastKey ra khỏi map
//        {                           //Last key trả về key lớn nhất trong treemap
//            treeMap.remove(treeMap.lastKey());//=> Last key còn lại là phần tử lớn thứ n
//        }
//        return treeMap.lastKey();
//    }
    private static int findKeyOrder(TreeMap<Integer, Integer> treeMap, int n)
    {
        Integer max = treeMap.lastKey();//Giá trị key lớn nhất ban đầu (n=1)
        for (int i = 1; i < n; i++)
        {                                //lowerKey trả về key bé hơn max 1 bậc
            max = treeMap.lowerKey(max);//Gán lại giá này n-1 lần => Giá trị nằm ở vị trí thứ n
        }
        return max;
    }
}
