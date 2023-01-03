package com.padr.buynow.outbound.persistence.shipment.port;

import com.padr.buynow.domain.core.shipment.entity.Shipment;
import com.padr.buynow.outbound.persistence.shipment.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ShipmentPersistencePortImpl implements ShipmentPersistencePort {

    private final ShipmentRepository shipmentRepository;

    @Override
    public Optional<Shipment> findById(Long id) {
        return shipmentRepository.findById(id);
    }

    @Override
    public Shipment save(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }
}
