package com.productapp.service;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;
import com.productapp.model.ProductDetails;
import com.productapp.model.ProductView;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);
    Product  getById(int productId);
    void updateProduct(Product product);
    void deleteProduct(int productId);

    List<Product>  getAll();
    List<Product>  getByBrandStartingWith(String brand);
    List<Product>  getByCategory(String category);
    List<Product>  getByBrandAndPrice(String brand,double price);
    List<Product> getByChoice(String choice);

    List<ProductDTO> getByBrand(String brand);
    List<ProductDetails> getProductByCategory(String category);
    List<ProductView> getByPrice(double price);


}
