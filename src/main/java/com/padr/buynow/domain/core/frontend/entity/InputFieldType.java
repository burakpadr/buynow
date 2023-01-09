package com.padr.buynow.domain.core.frontend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.common.entity.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "input_field_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class InputFieldType extends BaseEntity {
    
    @Id
    @SequenceGenerator(name = "input_field_type_id_seq", sequenceName = "input_field_type_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "input_field_type_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private Boolean hasMultipleValue;

    @Column
    private Boolean isActive;
}
