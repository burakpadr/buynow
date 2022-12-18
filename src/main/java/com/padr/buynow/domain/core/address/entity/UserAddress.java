package com.padr.buynow.domain.core.address.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_addresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAddress {
    
    @Id
    @SequenceGenerator(name = "user_address_id_seq", sequenceName = "user_address_id_seq") 
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_address_id_seq")
    private Long id;

    @Column
    private String addressName;

    @Column
    private String countryName;

    @Column
    private String stateName;

    @Column 
    private String cityName;

    @ManyToOne
    private User user;
}
