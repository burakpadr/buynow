package com.padr.buynow.outbound.persistence.notice.port;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.outbound.persistence.notice.repository.TraditionalNoticeRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TraditionalNoticePersistencePortImpl implements TraditionalNoticePersistencePort {
    
    private final TraditionalNoticeRepository traditionalNoticeRepository;

    @Override
    public Optional<TraditionalNotice> findById(Long id) {
        return traditionalNoticeRepository.findById(id);
    }

    @Override
    public TraditionalNotice save(TraditionalNotice traditionalNotice) {
        return traditionalNoticeRepository.save(traditionalNotice);
    }
}
