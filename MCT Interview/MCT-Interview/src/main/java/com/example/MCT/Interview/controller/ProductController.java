package com.example.MCT.Interview.controller;

import com.example.MCT.Interview.exception.FoundNothing;
import com.example.MCT.Interview.ProductService;
import com.example.MCT.Interview.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
       return productService.addProduct(product);
    }
    @GetMapping("/getById")
    public Product getAll(@RequestParam(value="id") Integer id) throws FoundNothing{
            return productService.getproductById(id);
    }

    @DeleteMapping("/deleteProduct")
    public String deleteProduct(@RequestParam Integer id) throws FoundNothing {
        return productService.deleteProduct(id);
    }
    
    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam(value = "id") Integer id){
        return productService.getMeProduct(id);
    }
}
