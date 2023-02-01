package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;

import java.util.List;

    @CrossOrigin (origins = "http://localhost:3010")
    @RequestMapping("/api/v1")
    @RestController
    public class ProductController {

    @Autowired
    ProductService productService;


    @GetMapping("/products")
    public List<Product> getAllProduct() {
        return productService.getAllproducts();

    }

    @GetMapping("/products/tshirts")
    public List<Product> getTshirts() {
        String category = "tshirts";
        return productService.getProductFromCategory(category);
    }

    @GetMapping("/products/bags")
    public List<Product> getBags() {
        String category = "bags";
        return productService.getProductFromCategory(category);
    }

    @GetMapping("/products/jackets")
    public List<Product> getJackets() {
        String category = "jackets";
        return productService.getProductFromCategory(category);
    }

    @GetMapping("/products/hats")
    public List<Product> gethats() {
        String category = "hats";
        return productService.getProductFromCategory(category);
    }

    @GetMapping("products/{id}")
    public Product getSpecificProduct(int id){

        return productService.getSpecificProductWithId(id);
    }
}