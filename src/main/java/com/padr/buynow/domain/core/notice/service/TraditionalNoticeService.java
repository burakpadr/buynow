package com.padr.buynow.domain.core.notice.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.domain.core.notice.exception.TraditionalNoticeNotFoundException;
import com.padr.buynow.outbound.persistence.notice.port.TraditionalNoticePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TraditionalNoticeService {

    private final TraditionalNoticePersistencePort traditionalNoticePersistencePort;

    public TraditionalNotice create(TraditionalNotice traditionalNotice) {
        traditionalNotice.setIsActive(true);

        return traditionalNoticePersistencePort.save(traditionalNotice);
    }

    public TraditionalNotice findById(Long id) {
        return traditionalNoticePersistencePort.findById(id).orElseThrow(TraditionalNoticeNotFoundException::new);
    }

    public TraditionalNotice update(Long id, TraditionalNotice updateTraditionalNotice) {
        TraditionalNotice traditionalNotice = findById(id);

        traditionalNotice.setBasePrice(updateTraditionalNotice.getBasePrice());
        traditionalNotice.setIsPublished(updateTraditionalNotice.getIsPublished());

        return traditionalNoticePersistencePort.save(traditionalNotice);
    }

    public void delete(Long id) {
        TraditionalNotice traditionalNotice = findById(id);

        traditionalNotice.setIsActive(false);

        traditionalNoticePersistencePort.save(traditionalNotice);
    }
}
