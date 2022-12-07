package com.productapp.controllers;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;
import com.productapp.model.ProductDetails;
import com.productapp.model.ProductView;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-api")
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private IProductService productService;

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/products")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        productService.addProduct(product);
        ResponseEntity<Void> responseEntity =
                ResponseEntity.status(HttpStatus.CREATED).build();
        return responseEntity;
    }
    @PutMapping("/products")
    ResponseEntity<Void> updateProduct(@RequestBody Product product){
        productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/products/productId/{productId}")
    ResponseEntity<Void> deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","deleting one product by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }
    @GetMapping("/products/productId/{productId}")
    ResponseEntity<Product>  getById(@PathVariable("productId") int productId){
        Product product = productService.getById(productId);
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","get one product by Id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(product);
    }


    @GetMapping("/products")
    public ResponseEntity<List<Product>>  getAll(){
        List<Product> products = productService.getAll();
        HttpHeaders headers = new HttpHeaders();
        headers.add("desc","getting all products");
        headers.add("info","Get All Method called");
        ResponseEntity<List<Product>> productResponse =
                new ResponseEntity(products,headers, HttpStatus.OK);
        return productResponse;
    }
    @GetMapping("/products/brand-starting/{brand}")
    public ResponseEntity<List<Product>>  getByBrandStartingWith(@PathVariable("brand") String brand){
        List<Product> products = productService.getByBrandStartingWith(brand);
        ResponseEntity<List<Product>> productResponse = ResponseEntity.ok().body(products);
        return  productResponse;

    }
    @GetMapping("/products/brand/{brand}")
    public ResponseEntity<List<ProductDTO>>  getByBrand(@PathVariable("brand") String brand){
        List<ProductDTO> products = productService.getByBrand(brand);
        ResponseEntity<List<ProductDTO>> productResponse = ResponseEntity.ok().body(products);
        return  productResponse;

    }
    @GetMapping("/products/category/{category}")
    public ResponseEntity<List<Product>>  getByCategory(@PathVariable("category") String category){
        List<Product> products = productService.getByCategory(category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by category "+category);
        return ResponseEntity.ok().headers(httpHeaders).body(products);

    }
    @GetMapping("/products/cat/{category}")
    public ResponseEntity<List<ProductDetails>>  getProductByCategory(@PathVariable("category") String category){
        List<ProductDetails> products = productService.getProductByCategory(category);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by category "+category);
        return ResponseEntity.ok().headers(httpHeaders).body(products);

    }
    @GetMapping("/products/price/{price}")
    ResponseEntity<List<ProductView>> getByPriceLessThan(double price){
        List<ProductView> products = productService.getByPrice(price);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by lesser price "+price);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(products);
    }
    @GetMapping("/products/brand/{brand}/price/{price}")
    ResponseEntity<List<Product>>  getByBrandAndPrice(String brand,double price){
        List<Product> products = productService.getByBrandAndPrice(brand,price);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by brand "+brand+" lesser price "+price);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(products);
    }
    @GetMapping("/products/choice/{choice}")
    ResponseEntity<List<Product>> getByChoice(String choice){
        List<Product> products = productService.getByChoice(choice);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("desc","Get by brand or category "+choice);
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body(products);

    }

}
