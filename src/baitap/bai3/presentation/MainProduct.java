package baitap.bai3.presentation;

import baitap.Utility;
import baitap.bai3.business.design.Manageable;
import baitap.bai3.business.implementation.ProductManager;

public class MainProduct
{
    public static void main(String[] args)
    {
        Manageable productManager = new ProductManager();
        while (true)
        {
            System.out.println("==========MENU==============");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa sản phẩm theo id");
            System.out.println("3. Xóa sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá");
            System.out.println("0. Thoát");
            int choice = Integer.parseInt(Utility.scanner.nextLine());
            switch (choice)
            {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.editProduct();
                    break;
                case 3:
                    productManager.deleteProduct();
                    break;
                case 4:
                    productManager.displayAllProduct();
                    break;
                case 5:
                    productManager.searchProductByName();
                    break;
                case 6:
                    productManager.sortProduct();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không khả dụng");
                    break;
            }

        }
    }
}
