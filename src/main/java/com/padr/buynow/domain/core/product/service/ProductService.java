package com.padr.buynow.domain.core.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.cart.entity.CartItem;
import com.padr.buynow.domain.core.cart.service.CartItemService;
import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.product.exception.ProductNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    
    private final ProductPersistencePort productPersistencePort;

    private final CartItemService cartItemService;

    public Product create(Product product) {
        product.setIsActive(true);

        return productPersistencePort.save(product);
    }

    public Product findById(Long id) {
        return productPersistencePort.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product update(Long id, Product updateProduct) {
        Product product = findById(id);

        product.setHeader(updateProduct.getHeader());
        product.setDescription(updateProduct.getDescription());
        product.setNoticeType(updateProduct.getNoticeType());
        product.setAuctionNotice(updateProduct.getAuctionNotice());
        product.setTraditionalNotice(updateProduct.getTraditionalNotice());

        //notifyTheObservers(product);

        return productPersistencePort.save(product);
    }

    public void delete(Long id) {
        Product product = findById(id);

        product.setIsActive(false);

        productPersistencePort.save(product);
    }

    // private void notifyTheObservers(Product product) {
    //     List<CartItem> cartItems = cartItemService.findByProductId(product.getId());

    //     cartItems.parallelStream().forEach(cartItem -> {
    //         cartItemService.update(cartItem.getCartId(), product);
    //     });
    // }
}
