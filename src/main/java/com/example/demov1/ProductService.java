package com.example.demov1;

import java.util.List;

public interface ProductService
{
    List<Product> getAllProducts();
    Product saveProduct(String name,float price);
}