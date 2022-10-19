package com.padr.buynow.domain.attribute.entity;

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
@Table(name = "attribute_values")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttributeValue {
    
    @Id
    @SequenceGenerator(name = "attribute_value_id_seq", sequenceName = "attribute_value_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_value_id_seq")
    private Long id;

    @Column
    private String value;

    @Column
    private Boolean isActive;

    @OneToOne
    private Attribute attribute;
}
