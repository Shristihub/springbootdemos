package com.productapp.repository;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;
import com.productapp.model.ProductDetails;
import com.productapp.model.ProductView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByCategory(String category);
    List<Product> findByBrandStartingWith(String brand);
//    List<Product> getByPriceLessThan(double price);
    List<ProductDTO> getByBrand(String brand);
    List<ProductDetails> getByCategory(String category);
    List<ProductView> getByPriceLessThan(double price);


}
