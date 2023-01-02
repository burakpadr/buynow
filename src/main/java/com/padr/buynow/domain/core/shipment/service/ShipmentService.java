package com.padr.buynow.domain.core.shipment.service;

import com.padr.buynow.domain.core.shipment.entity.Shipment;
import com.padr.buynow.outbound.persistence.shipment.port.ShipmentPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentPersistencePort shipmentPersistencePort;

    public Shipment create(Shipment shipment) {
        return shipmentPersistencePort.save(shipment);
    }
}
