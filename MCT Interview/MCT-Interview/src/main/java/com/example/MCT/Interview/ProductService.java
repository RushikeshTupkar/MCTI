package com.example.MCT.Interview;

import com.example.MCT.Interview.exception.FoundNothing;
import com.example.MCT.Interview.model.Product;
import com.example.MCT.Interview.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private IProductRepository productRepository;
    public Product addProduct(Product product) {
        product.setDate(new Date(System.currentTimeMillis()));
        return productRepository.save(product);
    }

    public Product getproductById(Integer id) throws FoundNothing {
        if(!productRepository.findById(id).isPresent()){
            throw new FoundNothing("Nothing is present");
        }
        return productRepository.findById(id).get();
    }

    public String deleteProduct(Integer id) throws FoundNothing {
        if(!productRepository.findById(id).isPresent()){
            throw new FoundNothing("Nothing is present to delete");
        }
        productRepository.deleteById(id);
        return "Successful";
    }
}
