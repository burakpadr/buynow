package com.padr.buynow.outbound.persistence.product.port;

import java.util.List;

import com.padr.buynow.domain.core.product.entity.ProductAttribute;
import com.padr.buynow.outbound.common.BaseCacheAndPersistencePort;

public interface ProductAttributePersistencePort extends BaseCacheAndPersistencePort<ProductAttribute> {
    
    List<ProductAttribute> findByProductId(Long productId);

    List<ProductAttribute> saveAll(List<ProductAttribute> productAttributes);
}
