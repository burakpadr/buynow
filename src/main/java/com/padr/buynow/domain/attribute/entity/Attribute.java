package com.padr.buynow.domain.attribute.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

import com.padr.buynow.domain.frontend.entity.InputFieldType;
import com.padr.buynow.domain.product.entity.ProductTypeAttributeGroup;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "attributes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attribute {
    
    @Id
    @SequenceGenerator(name = "attribute_id_seq", sequenceName = "attribute_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attribute_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String label;

    @Column Boolean isActive;

    @OneToOne
    private InputFieldType inputFieldType;

    @ManyToMany(mappedBy = "attributes")
    @Transient
    private List<ProductTypeAttributeGroup> productTypeAttributeGroups;
}
