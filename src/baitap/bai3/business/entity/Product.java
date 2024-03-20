package baitap.bai3.business.entity;

import baitap.Utility;

public class Product
{
    private int id;
    private static int maxId = 1;
    private String name;
    private double price;

    public Product()
    {
        this.id = maxId++;//Id tự tăng
    }

    public Product(String name, double price)
    {
        this.id = maxId++;//Id tự tăng
        this.name = name;
        this.price = price;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void inputData()
    {   //Đảm bảo encapsulation
        System.out.println("Nhập tên sản phẩm");
        this.name = Utility.scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        this.price = Double.parseDouble(Utility.scanner.nextLine());
    }

    public void displayData()
    {   //Đảm bảo encapsulation
        System.out.println("ID sản phẩm: " + this.id);
        System.out.println("Tên sản phẩm: " + this.name);
        System.out.println("Giá sản phẩm: " + this.price);
    }
}
