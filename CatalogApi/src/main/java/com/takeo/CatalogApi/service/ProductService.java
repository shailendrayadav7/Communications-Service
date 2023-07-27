package com.takeo.CatalogApi.service;

import com.takeo.CatalogApi.model.Product;
import com.takeo.CatalogApi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id){
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product productToUpdate = existingProduct.get();
            productToUpdate.setName(updatedProduct.getName());
            productToUpdate.setPrice(updatedProduct.getPrice());
            return productRepository.save(productToUpdate);
        } else {
            throw new IllegalArgumentException("Product with ID " + id + " not found");
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

}
