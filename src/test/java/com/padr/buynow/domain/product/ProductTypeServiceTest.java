package com.padr.buynow.domain.product;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
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

import com.padr.buynow.domain.product.entity.ProductType;
import com.padr.buynow.domain.product.exception.ProductTypeAlreadyExistWithNameException;
import com.padr.buynow.domain.product.exception.ProductTypeNotFoundException;
import com.padr.buynow.domain.product.service.ProductTypeService;
import com.padr.buynow.outbound.persistence.product.port.ProductTypePersistencePort;

@RunWith(MockitoJUnitRunner.class)
public class ProductTypeServiceTest {

    @Mock
    private ProductTypePersistencePort mockProductTypePersistencePort;

    @InjectMocks
    private ProductTypeService classUnderTest;

    @Test
    public void createProductType_successfully() {
        ProductType given = ProductType.builder()
                .name("name")
                .label("label")
                .build();

        ProductType expected = ProductType.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        when(mockProductTypePersistencePort.findByName(any())).thenReturn(Optional.empty());
        when(mockProductTypePersistencePort.save(given)).thenReturn(expected);

        ProductType actual = classUnderTest.createProductType(given);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void createProductType_throwException_ifProductTypeExistWithName() {
        ProductType productType = new ProductType();

        when(mockProductTypePersistencePort.findByName(any())).thenReturn(Optional.of(productType));

        ThrowingRunnable runnable = () -> classUnderTest.createProductType(productType);

        assertThrows(ProductTypeAlreadyExistWithNameException.class, runnable);
    }

    @Test
    public void findById_successfully() {
        ProductType expected = ProductType.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        when(mockProductTypePersistencePort.findById(any())).thenReturn(Optional.of(expected));

        ProductType actual = classUnderTest.findById(any());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void findById_throwException_when_ProductTypeNotFound() {
        when(mockProductTypePersistencePort.findById(any())).thenReturn(Optional.empty());

        ThrowingRunnable runnable = () -> classUnderTest.findById(any());

        assertThrows(ProductTypeNotFoundException.class, runnable);
    }

    @Test
    public void findByName_successfully() {
        ProductType expected = ProductType.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        when(mockProductTypePersistencePort.findByName(any())).thenReturn(Optional.of(expected));

        ProductType actual = classUnderTest.findByName(any());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void findByName_throwException_when_ProductTypeNotFound() {
        when(mockProductTypePersistencePort.findByName(any())).thenReturn(Optional.empty());

        ThrowingRunnable runnable = () -> classUnderTest.findByName(any());

        assertThrows(ProductTypeNotFoundException.class, runnable);
    }

    @Test
    public void findByParentProductTypeId_successfully() {
        List<ProductType> expected = List.of(ProductType.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build());

        when(mockProductTypePersistencePort.findByParentProductTypeId(any())).thenReturn(expected);

        List<ProductType> actual = classUnderTest.findByParentProductTypeId(any());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void updateProductType_successfully() {
        ProductType given = ProductType.builder()
                .name("updated_name")
                .label("updated_label")
                .build();

        ProductType originalProductType = ProductType.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        ProductType expected = ProductType.builder()
                .id(1L)
                .name("updated_name")
                .label("updated_label")
                .isActive(true)
                .build();

        when(mockProductTypePersistencePort.findById(any())).thenReturn(Optional.of(originalProductType));
        when(mockProductTypePersistencePort.findByName(any())).thenReturn(Optional.empty());
        when(mockProductTypePersistencePort.save(any())).thenReturn(expected);

        ProductType actual = classUnderTest.updateProductType(any(), given);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void updateProductType_throwException_ifProductTypeIsExistWithNameAndNotSelf() {
        ProductType originalProductType = ProductType.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        ProductType otherProductType = ProductType.builder()
                .id(2L)
                .name("name")
                .label("second_label")
                .isActive(true)
                .build();

        when(mockProductTypePersistencePort.findById(any())).thenReturn(Optional.of(originalProductType));
        when(mockProductTypePersistencePort.findByName(any())).thenReturn(Optional.of(otherProductType));

        ThrowingRunnable runnable = () -> classUnderTest.updateProductType(any(), new ProductType());

        assertThrows(ProductTypeAlreadyExistWithNameException.class, runnable);
    }

    @Test
    public void deleteById_successfully() {
        ProductType productType = new ProductType();

        when(mockProductTypePersistencePort.findById(any())).thenReturn(Optional.of(productType));
        when(mockProductTypePersistencePort.save(any())).thenReturn(null);

        classUnderTest.deleteById(any());

        verify(mockProductTypePersistencePort, times(1)).findById(any());
        verify(mockProductTypePersistencePort, times(1)).save(any());
    }
}
