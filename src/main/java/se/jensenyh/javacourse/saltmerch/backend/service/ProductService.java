package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;

    @Service
    public class ProductService {

    @Autowired
    ProductRepository ProductDataBase;



        public List<Product> getAllproducts() {

            return ProductDataBase.selectAll();
        }

        public List<Product> getProductFromCategory(String category) {
            return ProductDataBase.selectAllOfCategory(category);
        }

        public Product getSpecificProductWithId(int id) {

            return ProductDataBase.getEntireProduct(id);
        }
    }
