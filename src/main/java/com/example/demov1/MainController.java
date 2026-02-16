package com.example.demov1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController
{
    @Autowired
    private ProductService productService;

    // task 1
    // update, delete, getProductById(1)

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }

    @PostMapping("/save") // /save?name=''&price=
    public Product save(@RequestParam String name,@RequestParam float price)
    {
        return productService.saveProduct(name,price);
    }
}