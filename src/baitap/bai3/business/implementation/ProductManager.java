package baitap.bai3.business.implementation;

import baitap.Utility;
import baitap.bai3.business.design.Manageable;
import baitap.bai3.business.entity.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ProductManager implements Manageable
{
    private static final List<Product> listProduct = new ArrayList<>();

    @Override
    public void addProduct()
    {
        Product newProduct = new Product();
        newProduct.inputData();
        listProduct.add(newProduct);
    }

    @Override
    public void displayAllProduct()
    {
        if (listProduct.isEmpty())
        {
            System.out.println("Không có sản phẩm");
            return;
        }
        //List không rỗng thì mới cho hiển thị
        listProduct.forEach(product -> product.displayData());
    }

    @Override
    public void editProduct()
    {
        int index = searchProductById();//Gọi hàm để lấy index của sản phẩm trong list
        if (index == -1)
        {
            System.out.println("Không tìm thấy sản phẩm cần sửa");
            return;
        }
        //Tìm được sản phẩm thì hiện thông tin cũ và cho nhập thông tin mới
        System.out.println("Thông tin cũ: ");
        listProduct.get(index).displayData();
        System.out.println("-----------------------");
        System.out.println("Mời nhập thông tin mới");
        listProduct.get(index).inputData();
    }

    @Override
    public void deleteProduct()
    {
        int index = searchProductById();//Gọi hàm để lấy index của sản phẩm trong list
        if (index == -1)
        {
            System.out.println("Không tìm thấy sản phẩm cần xóa");
            return;
        }
        listProduct.remove(index);//Xóa sản phẩm ở vị trí index nếu có
        System.out.println("Sản phẩm đã được xóa");
    }

    private int searchProductById()
    {//Hàm nội bộ chỉ dùng để tìm index dựa trên id => Không đặt trong interface
        if (listProduct.isEmpty())
        {
            System.out.println("Không có sản phẩm");
            return -1;
        }
        System.out.println("Mời nhập id muốn tìm");
        int idSearch = Integer.parseInt(Utility.scanner.nextLine());
        for (int i = 0; i < listProduct.size(); i++)
        {
            if (listProduct.get(i).getId() == idSearch)
                return i;
        }
        return -1;
    }

    @Override
    public void searchProductByName()
    {
        if (listProduct.isEmpty())
        {
            System.out.println("Không có sản phẩm");
            return;
        }
        System.out.println("Mời nhập tên sản phẩm cần tìm");
        String searchName = Utility.scanner.nextLine();
        boolean isFound = false;//Flag để kiểm tra xem có tìm thấy sản phẩm nào không
        for (Product p : listProduct)
        {
            if (p.getName().contains(searchName))
            { //Tìm kiếm tương đối => Có thể có nhiều sản phẩm tương ứng => không break ngay
                System.out.println("Tìm thấy 1 sản phẩm có tên giống với sản phẩm cần tìm");
                p.displayData();
                isFound = true;
            }
        }
        if (!isFound)//Nếu không tìm được sản phẩm
            System.out.println("Không có sản phẩm giống với mô tả");
    }

    @Override
    public void sortProduct()
    {
        System.out.println("Nhập số 1 để sắp xếp sản phẩm tăng dần, 2 để sắp xếp giảm dần");
        int choice = Integer.parseInt(Utility.scanner.nextLine());
        switch (choice)
        {
            case 1://Sắp xếp tăng dần => Natural order của Comparable của class tương ứng
                listProduct.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
                displayAllProduct();//Hiển thị lại danh sách đã sắp xếp
                break;
            case 2://Sắp xếp giảm dần => Đảo ngược natural order của Comparable của class tương ứng
                listProduct.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
                displayAllProduct();//Hiển thị lại danh sách đã sắp xếp
                break;
            default:
                System.out.println("Lựa chọn không khả dụng");
                break;
        }
    }
}
