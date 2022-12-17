package com.padr.buynow.domain.core.product.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.padr.buynow.domain.core.notice.constant.NoticeType;
import com.padr.buynow.domain.core.notice.entity.AuctionNotice;
import com.padr.buynow.domain.core.notice.entity.TraditionalNotice;
import com.padr.buynow.domain.core.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    
    @Id
    @SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
    private Long id;

    @Column
    private String header;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private NoticeType noticeType;

    @Column
    private Boolean isActive;

    @OneToOne
    private ProductType productType;

    @OneToOne
    private User ownerUser;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<ProductAttribute> productAttributes;

    @OneToOne
    private AuctionNotice auctionNotice;

    @OneToOne
    private TraditionalNotice traditionalNotice;
}
