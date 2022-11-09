package com.padr.buynow.domain.product;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.padr.buynow.domain.product.entity.ProductTypeAttributeValue;
import com.padr.buynow.domain.product.exception.ProductTypeAttributeValueNotFoundException;
import com.padr.buynow.domain.product.service.ProductTypeAttributeValueService;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributeValuePersistencePort;

@RunWith(MockitoJUnitRunner.class)
public class ProductTypeAttributeValueServiceTest {

    @Mock
    private ProductTypeAttributeValuePersistencePort mockProductTypeAttributeValuePersistencePort;

    @InjectMocks
    private ProductTypeAttributeValueService classUnderTest;

    @Test
    public void create_successfully() {
        List<ProductTypeAttributeValue> given = List
                .of(ProductTypeAttributeValue.builder().value("value").build());

        List<ProductTypeAttributeValue> expected = List
                .of(ProductTypeAttributeValue.builder().id(1L).value("value").build());

        when(mockProductTypeAttributeValuePersistencePort.saveAll(given)).thenReturn(expected);

        List<ProductTypeAttributeValue> actual = classUnderTest.create(given);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertArrayEquals(expected.toArray(), actual.toArray()));
    }

    @Test
    public void fingById_successfully() {
        ProductTypeAttributeValue expected = ProductTypeAttributeValue.builder()
                .value("value")
                .build();

        when(mockProductTypeAttributeValuePersistencePort.findById(any())).thenReturn(Optional.of(expected));

        ProductTypeAttributeValue actual = classUnderTest.findById(any());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void findById_throwException_ifNotFound() {
        when(mockProductTypeAttributeValuePersistencePort.findById(any())).thenReturn(Optional.empty());

        ThrowingRunnable runnable = () -> classUnderTest.findById(any());

        assertThrows(ProductTypeAttributeValueNotFoundException.class, runnable);
    }

    @Test
    public void findByAttributeId_successfully() {
        List<ProductTypeAttributeValue> expected = List
                .of(ProductTypeAttributeValue.builder().id(1L).value("value").build(),
                        ProductTypeAttributeValue.builder().id(2L).value("value2").build());
        
        when(mockProductTypeAttributeValuePersistencePort.findByProductTypeAttributeIdAndIsActive(1L, true)).thenReturn(expected);

        List<ProductTypeAttributeValue> actual = classUnderTest.findByAttributeId(1L);

        assertAll(
            () -> assertNotNull(actual),
            () -> assertArrayEquals(expected.toArray(), actual.toArray())
        );
    }

    @Test
    public void update_successfully() {
        ProductTypeAttributeValue given = ProductTypeAttributeValue.builder()
                .value("updated-value")
                .build();

        ProductTypeAttributeValue originalProductTypeAttributeValue = ProductTypeAttributeValue.builder()
                .id(1L)
                .value("value")
                .isActive(true)
                .build();

        ProductTypeAttributeValue expected = ProductTypeAttributeValue.builder()
                .id(1L)
                .value("update-value")
                .isActive(true)
                .build();

        when(mockProductTypeAttributeValuePersistencePort.findById(any()))
                .thenReturn(Optional.of(originalProductTypeAttributeValue));
        when(mockProductTypeAttributeValuePersistencePort.save(originalProductTypeAttributeValue)).thenReturn(expected);

        ProductTypeAttributeValue actual = classUnderTest.update(any(), given);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void deleteById_successfully() {
        ProductTypeAttributeValue productTypeAttributeValue = new ProductTypeAttributeValue();

        when(mockProductTypeAttributeValuePersistencePort.findById(any()))
                .thenReturn(Optional.of(productTypeAttributeValue));
        when(mockProductTypeAttributeValuePersistencePort.save(any())).thenReturn(productTypeAttributeValue);

        classUnderTest.deleteById(any());

        verify(mockProductTypeAttributeValuePersistencePort, times(1)).findById(any());
        verify(mockProductTypeAttributeValuePersistencePort, times(1)).save(productTypeAttributeValue);
    }
}
