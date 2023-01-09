package com.padr.buynow.domain.core.user.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.address.entity.UserAddress;
import com.padr.buynow.domain.core.common.entity.BaseEntity;
import com.padr.buynow.domain.core.notice.entity.Bid;
import com.padr.buynow.domain.core.order.entity.Order;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    @Id
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private LocalDate birthDate;

    @Column
    private Boolean isActive;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<UserAddress> address;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserAddress> billingAddresses;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Bid> bids;

    @OneToMany(mappedBy = "buyer", fetch = FetchType.LAZY)
    private List<Order> orders;
}
