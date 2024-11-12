package com.example.applications;

import com.example.entities.Product;
import com.example.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ProductApplicationTest {
    @InjectMocks
    private ProductApplication ProductApplication;

    @Mock
    private ProductService ProductService;

    @Mock
    private Product Product;

    @Test
    public void VerificarSeSalvaAImagem() {
        Mockito.when(ProductService.save(Product)).thenReturn(true);

        ProductApplication.append(Product);

        Mockito.verify(ProductService, Mockito.times(1)).save(Product);
    }

    @Test
    public void DeveAtualizarImagem() {
        Mockito.when(Product.getId()).thenReturn(1);

        ProductApplication.update(Product.getId(), Product);

        Mockito.verify(ProductService, Mockito.times(1)).update(Mockito.any(Product.class));
    }

    @Test
    public void DeveRemoverImagem() {
        Mockito.when(Product.getId()).thenReturn(1);
        ProductApplication.remove(Product.getId());
        Mockito.verify(ProductService, Mockito.times(1)).remove(Product.getId());
    }
}
