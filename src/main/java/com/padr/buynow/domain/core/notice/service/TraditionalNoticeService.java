package com.padr.buynow.domain.core.notice.service;

import org.springframework.stereotype.Service;

import com.padr.buynow.domain.core.notice.constant.TraditionalNoticeStep;
import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.domain.core.notice.exception.NoticeIsLiveException;
import com.padr.buynow.domain.core.notice.exception.NoticeIsNotLiveException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBeInCargoException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBeInNoticeException;
import com.padr.buynow.domain.core.notice.exception.StepShouldBePreparingCargoException;
import com.padr.buynow.domain.core.notice.exception.TraditionalNoticeNotFoundException;
import com.padr.buynow.outbound.persistence.notice.port.TraditionalNoticePersistencePort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TraditionalNoticeService {

    private final TraditionalNoticePersistencePort traditionalNoticePersistencePort;

    public TraditionalNotice create(TraditionalNotice traditionalNotice) {
        traditionalNotice.setStep(TraditionalNoticeStep.IN_NOTICE);
        traditionalNotice.setIsActive(true);

        return traditionalNoticePersistencePort.save(traditionalNotice);
    }

    public TraditionalNotice findById(Long id) {
        return traditionalNoticePersistencePort.findById(id).orElseThrow(TraditionalNoticeNotFoundException::new);
    }

    public TraditionalNotice update(Long id, TraditionalNotice updateTraditionalNotice) {
        TraditionalNotice traditionalNotice = findById(id);

        if (traditionalNotice.getStep().equals(TraditionalNoticeStep.IN_NOTICE)) {
            traditionalNotice.setPrice(updateTraditionalNotice.getPrice());
            traditionalNotice.setIsPublished(updateTraditionalNotice.getIsPublished());

            return traditionalNoticePersistencePort.save(traditionalNotice);
        } else
            throw new StepShouldBeInNoticeException();
    }

    public void delete(Long id) {
        TraditionalNotice traditionalNotice = findById(id);

        traditionalNotice.setIsActive(false);

        traditionalNoticePersistencePort.save(traditionalNotice);
    }

    public void prepareTheCargo(Long id) {
        TraditionalNotice traditionalNotice = findById(id);

        if (traditionalNotice.getIsPublished()) {
            if (traditionalNotice.getStep().equals(TraditionalNoticeStep.IN_NOTICE)) {
                traditionalNotice.setIsPublished(false);
                traditionalNotice.setStep(TraditionalNoticeStep.PREPARING_CARGO);

                traditionalNoticePersistencePort.save(traditionalNotice);
            } else
                throw new StepShouldBeInNoticeException();
        } else
            throw new NoticeIsNotLiveException();
    }

    public void shipTheProduct(Long id) {
        TraditionalNotice traditionalNotice = findById(id);

        if (!traditionalNotice.getIsPublished()) {
            if (traditionalNotice.getStep().equals(TraditionalNoticeStep.PREPARING_CARGO)) {
                traditionalNotice.setStep(TraditionalNoticeStep.IN_CARGO);

                traditionalNoticePersistencePort.save(traditionalNotice);
            } else
                throw new StepShouldBePreparingCargoException();
        } else
            throw new NoticeIsLiveException();
    }

    public void completeTheSaleOfProduct(Long id) {
        TraditionalNotice traditionalNotice = findById(id);

        if (!traditionalNotice.getIsPublished()) {
            if (traditionalNotice.getStep().equals(TraditionalNoticeStep.IN_CARGO)) {
                traditionalNotice.setStep(TraditionalNoticeStep.SOLD);

                traditionalNoticePersistencePort.save(traditionalNotice);
            } else
                throw new StepShouldBeInCargoException();
        } else
            throw new NoticeIsLiveException();
    }
}
