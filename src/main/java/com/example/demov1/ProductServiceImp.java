package com.example.demov1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService
{
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product saveProduct(String name, float price)
    {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);

        return productRepo.save(product);
    }
}
