package se.jensenyh.javacourse.saltmerch.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductService service;

    @Test
    void canGetAllProducts(){

        Product prod1 = new Product(1, "hats", "Some hat", "Some hat 1", "");
        Product prod2 = new Product(2, "bag", "Some bag", "Some bag 1", "");
        List<Product> productList = new ArrayList<>();
        Collections.addAll(productList, prod1, prod2);
        when(productRepository.selectAll()).thenReturn(productList);
        assertEquals(productList,service.getAllproducts());
        verify(productRepository).selectAll();
    }
}
