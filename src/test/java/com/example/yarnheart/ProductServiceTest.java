package com.example.yarnheart;

import com.example.yarnheart.model.Product;
import com.example.yarnheart.repository.ProductRepository;
import com.example.yarnheart.service.ProductServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

   @Mock
   private ProductRepository productRepository;

   private ProductServiceImpl productServiceImpl;

   @Before
   public void setUp(){
       productServiceImpl = new ProductServiceImpl(productRepository);
       Product test = new Product();
       test.setName("test");
       test.setId(999L);

       Mockito.when(productRepository.findByName(test.getName())).thenReturn(test);
       Mockito.when(productRepository.findById(test.getId())).thenReturn(Optional.of(test));
   }

    @Test
    public void whenValidName_thenReturnProduct() {
        String name = "test";
        Product found = productServiceImpl.getProductByName(name);

        assertThat(found.getName()).isEqualTo(name);
    }

    @Test
    public void whenValidId_thenReturnProduct(){
       Long id = 999L;
       Product found = productServiceImpl.findProductById(id);

       assertThat(found.getId()).isEqualTo(id);
    }
}
