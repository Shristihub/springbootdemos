package com.productapp.service;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;
import com.productapp.model.ProductDetails;
import com.productapp.model.ProductView;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{

    private IProductRepository productRepository;
    @Autowired
    public void setProductRepository(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByBrandStartingWith(String brand) {
        return productRepository.findByBrandStartingWith(brand);
    }

    @Override
    public List<Product> getByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getByBrandAndPrice(String brand,double price) {
        return null;
    }

    @Override
    public List<Product> getByChoice(String choice) {
        return null;
    }

    @Override
    public List<ProductDTO> getByBrand(String brand) {
        return productRepository.getByBrand(brand);
    }

    @Override
    public List<ProductDetails> getProductByCategory(String category) {
        return productRepository.getByCategory(category);
    }

    @Override
    public List<ProductView> getByPrice(double price) {
        return productRepository.getByPriceLessThan(price);
    }


    @Override
    public Product getById(int productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
