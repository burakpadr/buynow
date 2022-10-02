package com.padr.buynow.domain.address.port;

import org.springframework.stereotype.Component;

import com.padr.buynow.domain.address.service.AddressScheduledJobService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AddressScheduledJobServicePortImpl implements AddressScheduledJobServicePort {
    
    private final AddressScheduledJobService addressScheduledJobService;

    @Override
    public void refreshAddressCache() {
        addressScheduledJobService.refreshAddressCache();
    }
}
