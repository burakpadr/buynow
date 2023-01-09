package com.padr.buynow.domain.core.product.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import com.padr.buynow.domain.core.frontend.entity.InputFieldType;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "attributes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductTypeAttribute extends BaseEntity {
    
    @Id
    @SequenceGenerator(name = "attribute_id_seq", sequenceName = "attribute_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_id_seq")
    private Long id;

    @Column
    private String label;

    @Column Boolean isActive;

    @OneToOne
    private InputFieldType inputFieldType;

    @ManyToOne
    private ProductTypeAttributeGroup productTypeAttributeGroup;

    @OneToMany(mappedBy = "productTypeAttribute", fetch = FetchType.LAZY)
    private List<ProductTypeAttributeValue> productTypeAttributeValues;
}
