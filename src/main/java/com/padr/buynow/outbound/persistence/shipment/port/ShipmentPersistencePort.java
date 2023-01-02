package com.padr.buynow.outbound.persistence.shipment.port;

import com.padr.buynow.domain.core.shipment.entity.Shipment;

public interface ShipmentPersistencePort {

    Shipment save(Shipment shipment);
}
