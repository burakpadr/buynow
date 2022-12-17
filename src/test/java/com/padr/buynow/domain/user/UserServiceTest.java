// package com.padr.buynow.domain.user;

// import static org.junit.Assert.assertThrows;
// import static org.junit.jupiter.api.Assertions.assertAll;
// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertNotNull;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.times;
// import static org.mockito.Mockito.verify;
// import static org.mockito.Mockito.when;

// import java.util.Optional;

// import org.junit.Test;
// import org.junit.function.ThrowingRunnable;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.MockitoJUnitRunner;
// import org.springframework.security.crypto.password.PasswordEncoder;

// import com.padr.buynow.domain.core.address.entity.UserAddress;
// import com.padr.buynow.domain.core.address.service.AddressService;
// import com.padr.buynow.domain.core.user.entity.User;
// import com.padr.buynow.domain.core.user.exception.UserAlreadyExistWithEmailException;
// import com.padr.buynow.domain.core.user.exception.UserAlreadyExistWithIdentityNumberException;
// import com.padr.buynow.domain.core.user.exception.UserNotFoundException;
// import com.padr.buynow.domain.core.user.service.UserService;
// import com.padr.buynow.outbound.persistence.user.port.UserPersistencePort;

// @RunWith(MockitoJUnitRunner.class)
// public class UserServiceTest {

//     @Mock
//     private UserPersistencePort mockUserPersistencePort;

//     @Mock
//     private AddressService mockAddressService;

//     @Mock
//     private PasswordEncoder mockPasswordEncoder;

//     @InjectMocks
//     private UserService classUnderTest;

//     @Test
//     public void createUser_successfully() {
//         UserAddress address = UserAddress.builder()
//                 .countryName("country")
//                 .stateName("state")
//                 .cityName("city")
//                 .build();

//         User user = User.builder()
//                 .password("password")
//                 .address(address)
//                 .build();

//         UserAddress expectedAddress = UserAddress.builder()
//                 .id(1L)
//                 .countryName("country")
//                 .stateName("state")
//                 .cityName("city")
//                 .build();

//         User expectedUser = User.builder()
//                 .id(1L)
//                 .password("encryptedPassword")
//                 .address(expectedAddress)
//                 .build();

//         when(mockUserPersistencePort.findByIdentityNumber(any())).thenReturn(Optional.empty());
//         when(mockUserPersistencePort.findByEmail(any())).thenReturn(Optional.empty());
//         when(mockAddressService.createAddress(address)).thenReturn(expectedAddress);
//         when(mockPasswordEncoder.encode(any())).thenReturn("encryptedPassword");
//         when(mockUserPersistencePort.save(user)).thenReturn(expectedUser);

//         User actual = classUnderTest.createUserIfNotExist(user);

//         assertAll(
//                 () -> assertNotNull(actual),
//                 () -> assertEquals(expectedUser, actual));
//     }

//     @Test
//     public void createUser_throwEXception_when_alreadyExistWithIdentityNumber() {
//         User user = User.builder()
//                 .identityNumber("identityNumber")
//                 .build();

//         when(mockUserPersistencePort.findByIdentityNumber(any())).thenReturn(Optional.of(user));

//         ThrowingRunnable runnable = () -> classUnderTest.createUserIfNotExist(user);

//         assertThrows(UserAlreadyExistWithIdentityNumberException.class, runnable);
//     }

//     @Test
//     public void createUser_throwEXception_when_alreadyExistWithEmail() {
//         User user = User.builder()
//                 .email("email")
//                 .build();

//         when(mockUserPersistencePort.findByIdentityNumber(any())).thenReturn(Optional.empty());
//         when(mockUserPersistencePort.findByEmail(any())).thenReturn(Optional.of(user));

//         ThrowingRunnable runnable = () -> classUnderTest.createUserIfNotExist(user);

//         assertThrows(UserAlreadyExistWithEmailException.class, runnable);
//     }

//     @Test
//     public void findById_successfully() {
//         User expected = User.builder()
//                 .id(1L)
//                 .name("name")
//                 .surname("surname")
//                 .identityNumber("identityNumber")
//                 .email("email")
//                 .password("password")
//                 .build();

//         when(mockUserPersistencePort.findById(any())).thenReturn(Optional.of(expected));

//         User actual = classUnderTest.findUserById(any());

//         assertAll(
//                 () -> assertNotNull(actual),
//                 () -> assertEquals(expected, actual));
//     }

//     @Test
//     public void findById_throwException_when_userNotFound() {
//         when(mockUserPersistencePort.findById(any())).thenReturn(Optional.empty());

//         ThrowingRunnable runnable = () -> classUnderTest.findUserById(any());

//         assertThrows(UserNotFoundException.class, runnable);
//     }

//     @Test
//     public void updateUser_successfully() {
//         User user = User.builder()
//                 .id(1L)
//                 .address(UserAddress.builder().id(2L).build())
//                 .build();

//         User expected = User.builder()
//                 .id(1L)
//                 .name("name")
//                 .surname("surname")
//                 .identityNumber("identityNumber")
//                 .email("email")
//                 .password("password")
//                 .isActive(true)
//                 .address(UserAddress.builder()
//                         .id(2L)
//                         .countryName("countryName")
//                         .stateName("stateName")
//                         .cityName("cityName")
//                         .build())
//                 .build();

//         when(mockUserPersistencePort.findById(any())).thenReturn(Optional.of(user));
//         when(mockUserPersistencePort.findByEmail(any())).thenReturn(Optional.empty());
//         when(mockAddressService.updateAddress(any(), any())).thenReturn(null);
//         when(mockUserPersistencePort.save(user)).thenReturn(expected);

//         User actual = classUnderTest.updateUser(any(), expected);

//         assertAll(
//                 () -> assertNotNull(actual),
//                 () -> assertEquals(expected, actual));
//     }

//     @Test
//     public void updateUser_throwException_when_ifUserPresentWithEmailAndNotSelf() {
//         User firstUser = User.builder()
//                 .id(1L)
//                 .email("email")
//                 .build();

//         User secondUser = User.builder()
//                 .id(2L)
//                 .email("email")
//                 .build();

//         when(mockUserPersistencePort.findById(any())).thenReturn(Optional.of(firstUser));
//         when(mockUserPersistencePort.findByEmail(any())).thenReturn(Optional.of(secondUser));

//         ThrowingRunnable runnable = () -> classUnderTest.updateUser(any(), secondUser);

//         assertThrows(UserAlreadyExistWithEmailException.class, runnable);
//     }

//     @Test
//     public void deleteUserById_successfully() {
//         User user = new User();

//         when(mockUserPersistencePort.findById(any())).thenReturn(Optional.of(user));
//         when(mockUserPersistencePort.save(any())).thenReturn(null);

//         classUnderTest.deleteUserById(any());

//         verify(mockUserPersistencePort, times(1)).findById(any());
//         verify(mockUserPersistencePort, times(1)).save(any());
//     }
// }
