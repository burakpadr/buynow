package com.padr.buynow.domain.core.product.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.notice.constant.NoticeType;
import com.padr.buynow.domain.core.notice.entity.AuctionNotice;
import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.domain.core.product.entity.Product;
import com.padr.buynow.domain.core.product.exception.ProductNotFoundException;
import com.padr.buynow.outbound.persistence.product.port.ProductPersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductPersistencePort productPersistencePort;

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

        return productPersistencePort.save(product);
    }

    public void setAuctionNotice(Long productId, AuctionNotice auctionNotice) {
        Product product = findById(productId);

        product.setNoticeType(NoticeType.AUCTION_NOTICE);
        product.setAuctionNotice(auctionNotice);

        productPersistencePort.save(product);
    }

    public void setTraditionalNotice(Long productId, TraditionalNotice traditionalNotice) {
        Product product = findById(productId);

        product.setNoticeType(NoticeType.TRADITIONAL_NOTICE);
        product.setTraditionalNotice(traditionalNotice);

        productPersistencePort.save(product);
    }

    public void delete(Long id) {
        Product product = findById(id);

        product.setIsActive(false);

        productPersistencePort.save(product);
    }
}
