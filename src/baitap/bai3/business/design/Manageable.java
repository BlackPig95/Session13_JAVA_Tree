package baitap.bai3.business.design;

import baitap.bai3.business.entity.Product;

public interface Manageable
{
    void addProduct(); //Thêm sản pẩm

    void displayAllProduct(); //Hiển thị thông tin tất cả sản phẩm

    void editProduct(); //Sửa thông tin sản phẩm

    void deleteProduct(); //Xóa sản phẩm

    void searchProductByName();//Tìm kiếm tương đối theo tên

    void sortProduct();//Sắp xếp sản phẩm

}
