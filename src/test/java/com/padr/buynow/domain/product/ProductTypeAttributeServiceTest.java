// package com.padr.buynow.domain.product;

// import static org.junit.Assert.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertAll;
// import static org.junit.jupiter.api.Assertions.assertArrayEquals;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.List;
// import java.util.Optional;

// import org.junit.Test;
// import org.junit.function.ThrowingRunnable;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.MockitoJUnitRunner;

// import com.padr.buynow.domain.core.product.entity.ProductTypeAttribute;
// import com.padr.buynow.domain.core.product.exception.ProductTypeAttributeNotFoundException;
// import com.padr.buynow.domain.core.product.service.ProductTypeAttributeService;
// import com.padr.buynow.outbound.persistence.product.port.ProductTypeAttributePersistencePort;

// @RunWith(MockitoJUnitRunner.class)
// public class ProductTypeAttributeServiceTest {

//     @Mock
//     private ProductTypeAttributePersistencePort mockProductTypeAttributePersistencePort;

//     @InjectMocks
//     private ProductTypeAttributeService classUnderTest;

//     @Test
//     public void create_successfully() {
//         ProductTypeAttribute given = ProductTypeAttribute.builder()
//                 .label("label")
//                 .build();

//         ProductTypeAttribute expected = ProductTypeAttribute.builder()
//                 .id(1L)
//                 .name("name")
//                 .label("label")
//                 .isActive(true)
//                 .build();

//         when(mockProductTypeAttributePersistencePort.findByName(any())).thenReturn(Optional.empty());
//         when(mockProductTypeAttributePersistencePort.save(given)).thenReturn(expected);

//         ProductTypeAttribute actual = classUnderTest.create(given);

//         assertAll(
//                 () -> assertNotNull(actual),
//                 () -> assertEquals(expected, actual));
//     }

//     @Test
//     public void create_throwExpcetion_ifProductTypeAttributeExistWithName() {
//         ProductTypeAttribute productTypeAttribute = ProductTypeAttribute.builder()
//                 .name("name")
//                 .label("label")
//                 .build();

//         when(mockProductTypeAttributePersistencePort.findByName(any())).thenReturn(Optional.of(productTypeAttribute));

//         ThrowingRunnable runnable = () -> classUnderTest.create(new ProductTypeAttribute());

//         assertThrows(ProductTypeAttributeAlreadyExistWithNameException.class, runnable);
//     }

//     @Test
//     public void findById_successfully() {
//         ProductTypeAttribute expected = ProductTypeAttribute.builder()
//                 .id(1L)
//                 .name("name")
//                 .label("label")
//                 .isActive(true)
//                 .build();

//         when(mockProductTypeAttributePersistencePort.findById(any())).thenReturn(Optional.of(expected));

//         ProductTypeAttribute actual = classUnderTest.findById(any());

//         assertAll(
//                 () -> assertNotNull(actual),
//                 () -> assertEquals(expected, actual));
//     }

//     @Test
//     public void findById_throwException_ifNotFound() {
//         when(mockProductTypeAttributePersistencePort.findById(any())).thenReturn(Optional.empty());

//         ThrowingRunnable runnable = () -> classUnderTest.findById(any());

//         assertThrows(ProductTypeAttributeNotFoundException.class, runnable);
//     }

//     @Test
//     public void findByName_successfully() {
//         ProductTypeAttribute expected = ProductTypeAttribute.builder()
//                 .id(1L)
//                 .name("name")
//                 .label("label")
//                 .isActive(true)
//                 .build();

//         when(mockProductTypeAttributePersistencePort.findByName(any())).thenReturn(Optional.of(expected));

//         ProductTypeAttribute actual = classUnderTest.findByName(any());

//         assertAll(
//                 () -> assertNotNull(actual),
//                 () -> assertEquals(expected, actual));
//     }

//     @Test
//     public void findByName_throwException_ifNotFound() {
//         when(mockProductTypeAttributePersistencePort.findByName(any())).thenReturn(Optional.empty());

//         ThrowingRunnable runnable = () -> classUnderTest.findByName(any());

//         assertThrows(ProductTypeAttributeNotFoundException.class, runnable);
//     }

//     @Test
//     public void findByProductTypeAttributeGroupId_successfully() {
//         ProductTypeAttribute firstProductTypeAttribute = ProductTypeAttribute.builder()
//                 .id(1L)
//                 .name("first-name")
//                 .label("first-label")
//                 .isActive(true)
//                 .build();

//         ProductTypeAttribute secondProductTypeAttribute = ProductTypeAttribute.builder()
//                 .id(2L)
//                 .name("second-name")
//                 .label("second-label")
//                 .isActive(true)
//                 .build();

//         List<ProductTypeAttribute> expected = List.of(firstProductTypeAttribute, secondProductTypeAttribute);

//         when(mockProductTypeAttributePersistencePort.findByProductTypeAttributeGroupId(any())).thenReturn(expected);

//         List<ProductTypeAttribute> actual = classUnderTest.findByProductTypeAttributeGroupId(any());

//         assertAll(
//                 () -> assertNotNull(expected),
//                 () -> assertArrayEquals(expected.toArray(), actual.toArray()));
//     }

//     @Test
//     public void update_successfully() {
//         ProductTypeAttribute given = ProductTypeAttribute.builder()
//                 .name("updated-name")
//                 .label("updated-label")
//                 .build();

//         ProductTypeAttribute originalProductTypeAttribute = ProductTypeAttribute.builder()
//                 .id(1L)
//                 .name("first-name")
//                 .label("first-label")
//                 .isActive(true)
//                 .build();

//         ProductTypeAttribute expected = ProductTypeAttribute.builder()
//                 .id(1L)
//                 .name("updated-name")
//                 .label("updated-label")
//                 .isActive(true)
//                 .build();

//         when(mockProductTypeAttributePersistencePort.findById(any()))
//                 .thenReturn(Optional.of(originalProductTypeAttribute));
//         when(mockProductTypeAttributePersistencePort.findByName(any())).thenReturn(Optional.empty());
//         when(mockProductTypeAttributePersistencePort.save(originalProductTypeAttribute)).thenReturn(expected);

//         ProductTypeAttribute actual = classUnderTest.update(any(), given);

//         assertAll(
//                 () -> assertNotNull(actual),
//                 () -> assertEquals(expected, actual));
//     }

//     @Test
//     public void updateProductType_throwException_ifProductTypeAttributeGroupIsExistWithNameAndNotSelf() {
//         ProductTypeAttribute originalProductTypeAttribute = ProductTypeAttribute.builder()
//                 .id(1L)
//                 .name("name")
//                 .label("label")
//                 .isActive(true)
//                 .build();

//         ProductTypeAttribute otherProductTypeAttribute = ProductTypeAttribute.builder()
//                 .id(2L)
//                 .name("name")
//                 .label("label")
//                 .isActive(true)
//                 .build();

//         when(mockProductTypeAttributePersistencePort.findById(any()))
//                 .thenReturn(Optional.of(originalProductTypeAttribute));
//         when(mockProductTypeAttributePersistencePort.findByName(any()))
//                 .thenReturn(Optional.of(otherProductTypeAttribute));

//         ThrowingRunnable runnable = () -> classUnderTest.update(any(), new ProductTypeAttribute());

//         assertThrows(ProductTypeAttributeAlreadyExistWithNameException.class, runnable);
//     }

//     @Test
//     public void deleteById_successfully() {
//         ProductTypeAttribute productTypeAttribute = new ProductTypeAttribute();

//         when(mockProductTypeAttributePersistencePort.findById(any())).thenReturn(Optional.of(productTypeAttribute));
//         when(mockProductTypeAttributePersistencePort.save(productTypeAttribute)).thenReturn(productTypeAttribute);

//         classUnderTest.deleteById(any());

//         verify(mockProductTypeAttributePersistencePort, times(1)).findById(any());
//         verify(mockProductTypeAttributePersistencePort, times(1)).save(productTypeAttribute);
//     }
// }
