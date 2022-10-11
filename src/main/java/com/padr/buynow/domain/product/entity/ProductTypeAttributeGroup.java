package com.padr.buynow.domain.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_type_attribute_groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductTypeAttributeGroup {
    
    @Id
    @SequenceGenerator(name = "product_type_attribute_group_id_seq", sequenceName = "product_type_attribute_group_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_type_attribute_group_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String label;

    @Column
    private Boolean isActive;

    @ManyToOne
    private ProductType productType;
}
