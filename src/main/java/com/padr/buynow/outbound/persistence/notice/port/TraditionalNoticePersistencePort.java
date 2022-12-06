package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;

public interface TraditionalNoticePersistencePort {
    
    Optional<TraditionalNotice> findById(Long id);

    TraditionalNotice save(TraditionalNotice traditionalNotice);
}
