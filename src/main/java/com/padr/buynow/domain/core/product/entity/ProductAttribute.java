package com.padr.buynow.domain.core.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_attributes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductAttribute {
    
    @Id
    @SequenceGenerator(name = "product_attribute_id_seq", sequenceName = "product_attribute_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_attribute_id_seq")
    private Long id;

    @Column
    private String value;

    @Column
    private Boolean isActive;

    @ManyToOne
    private Product product;

    @OneToOne
    private ProductTypeAttribute productTypeAttribute;

    @OneToOne
    private ProductTypeAttributeValue productTypeAttributeValue;
}
