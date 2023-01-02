package com.padr.buynow.outbound.persistence.shipment.repository;

import com.padr.buynow.domain.core.shipment.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
