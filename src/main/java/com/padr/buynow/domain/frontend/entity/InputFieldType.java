package com.padr.buynow.domain.frontend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "input_field_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InputFieldType {
    
    @Id
    @SequenceGenerator(name = "input_field_type_id_seq", sequenceName = "input_field_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "input_field_type_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean hasMultipleValues;

    @Column
    private Boolean isActive;
}
