package com.padr.buynow.domain.product;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.padr.buynow.domain.core.product.entity.ProductTypeAttributeGroup;
import com.padr.buynow.domain.core.product.exception.ProductTypeAttributeGroupAlreadyExistWithNameException;
import com.padr.buynow.domain.core.product.exception.ProductTypeAttributeGroupNotFoundException;
import com.padr.buynow.domain.core.product.service.ProductTypeAttributeGroupService;
import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributeGroupPersistencePort;

@RunWith(MockitoJUnitRunner.class)
public class ProductTypeAttributeGroupServiceTest {

    @Mock
    private ProductTypeAttributeGroupPersistencePort mockProductTypeAttributeGroupPersistencePort;

    @InjectMocks
    private ProductTypeAttributeGroupService classUnderTest;

    @Test
    public void create_successfully() {
        ProductTypeAttributeGroup given = ProductTypeAttributeGroup.builder()
                .name("name")
                .label("label")
                .build();

        ProductTypeAttributeGroup expected = ProductTypeAttributeGroup.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        when(mockProductTypeAttributeGroupPersistencePort.findByName(any())).thenReturn(Optional.empty());
        when(mockProductTypeAttributeGroupPersistencePort.save(any())).thenReturn(expected);

        ProductTypeAttributeGroup actual = classUnderTest.create(given);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void create_throwException_ifProductTypeAttributeGroupIsExistWithName() {
        ProductTypeAttributeGroup productTypeAttributeGroup = new ProductTypeAttributeGroup();

        when(mockProductTypeAttributeGroupPersistencePort.findByName(any()))
                .thenReturn(Optional.of(productTypeAttributeGroup));

        ThrowingRunnable runnable = () -> classUnderTest.create(new ProductTypeAttributeGroup());

        assertThrows(ProductTypeAttributeGroupAlreadyExistWithNameException.class, runnable);
    }

    @Test
    public void findById_successfully() {
        ProductTypeAttributeGroup expected = ProductTypeAttributeGroup.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        when(mockProductTypeAttributeGroupPersistencePort.findById(any())).thenReturn(Optional.of(expected));

        ProductTypeAttributeGroup actual = classUnderTest.findById(any());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void findById_throwException_ifProductTypeAttributeGroupNotFound() {
        when(mockProductTypeAttributeGroupPersistencePort.findById(any())).thenReturn(Optional.empty());

        ThrowingRunnable runnable = () -> classUnderTest.findById(any());

        assertThrows(ProductTypeAttributeGroupNotFoundException.class, runnable);
    }

    @Test
    public void findByName_successfully() {
        ProductTypeAttributeGroup expected = ProductTypeAttributeGroup.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        when(mockProductTypeAttributeGroupPersistencePort.findByName(any())).thenReturn(Optional.of(expected));

        ProductTypeAttributeGroup actual = classUnderTest.findByName(any());

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void findByName_throwException_ifProductTypeAttributeGroupNotFound() {
        when(mockProductTypeAttributeGroupPersistencePort.findByName(any())).thenReturn(Optional.empty());

        ThrowingRunnable runnable = () -> classUnderTest.findByName(any());

        assertThrows(ProductTypeAttributeGroupNotFoundException.class, runnable);
    }

    @Test
    public void update_successfully() {
        ProductTypeAttributeGroup given = ProductTypeAttributeGroup.builder()
                .name("updated-name")
                .label("updated-label")
                .build();

        ProductTypeAttributeGroup originalProductTypeAttributeGroup = ProductTypeAttributeGroup.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        ProductTypeAttributeGroup expected = ProductTypeAttributeGroup.builder()
                .id(1L)
                .name("updated-name")
                .label("updated-label")
                .isActive(true)
                .build();

        when(mockProductTypeAttributeGroupPersistencePort.findById(any()))
                .thenReturn(Optional.of(originalProductTypeAttributeGroup));
        when(mockProductTypeAttributeGroupPersistencePort.findByName(any())).thenReturn(Optional.empty());
        when(mockProductTypeAttributeGroupPersistencePort.save(originalProductTypeAttributeGroup)).thenReturn(expected);

        ProductTypeAttributeGroup actual = classUnderTest.update(any(), given);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(expected, actual));
    }

    @Test
    public void updateProductType_throwException_ifProductTypeAttributeGroupIsExistWithNameAndNotSelf() {
        ProductTypeAttributeGroup originalProductTypeAttributeGroup = ProductTypeAttributeGroup.builder()
                .id(1L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        ProductTypeAttributeGroup otherProductTypeAttributeGroup = ProductTypeAttributeGroup.builder()
                .id(2L)
                .name("name")
                .label("label")
                .isActive(true)
                .build();

        when(mockProductTypeAttributeGroupPersistencePort.findById(any()))
                .thenReturn(Optional.of(originalProductTypeAttributeGroup));
        when(mockProductTypeAttributeGroupPersistencePort.findByName(any())).thenReturn(Optional.of(otherProductTypeAttributeGroup));

        ThrowingRunnable runnable = () -> classUnderTest.update(any(), new ProductTypeAttributeGroup());

        assertThrows(ProductTypeAttributeGroupAlreadyExistWithNameException.class, runnable);
    }

    @Test
    public void deleteById_successfully() {
        ProductTypeAttributeGroup productTypeAttributeGroup = new ProductTypeAttributeGroup();

        when(mockProductTypeAttributeGroupPersistencePort.findById(any()))
                .thenReturn(Optional.of(productTypeAttributeGroup));
        when(mockProductTypeAttributeGroupPersistencePort.save(any())).thenReturn(null);

        classUnderTest.deleteById(any());

        verify(mockProductTypeAttributeGroupPersistencePort, times(1)).findById(any());
        verify(mockProductTypeAttributeGroupPersistencePort, times(1)).save(any());
    }
}
