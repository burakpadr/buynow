package com.padr.buynow.domain.core.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "attribute_values")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductTypeAttributeValue extends BaseEntity {
    
    @Id
    @SequenceGenerator(name = "attribute_value_id_seq", sequenceName = "attribute_value_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_value_id_seq")
    private Long id;

    @Column
    private String value;

    @Column
    private Boolean isActive;

    @ManyToOne
    private ProductTypeAttribute productTypeAttribute;
}
