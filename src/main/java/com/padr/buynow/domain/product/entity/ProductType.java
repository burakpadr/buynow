package com.padr.buynow.domain.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductType {
    
    @Id
    @SequenceGenerator(name = "product_type_id_seq", sequenceName = "product_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_type_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Boolean isActive;

    @OneToOne
    private ProductType parentProductType;
}
