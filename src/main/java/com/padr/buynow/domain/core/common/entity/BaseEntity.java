package com.padr.buynow.domain.core.common.entity;

import com.padr.buynow.domain.core.common.util.IpFinderUtil;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
@SuperBuilder
@NoArgsConstructor
public class BaseEntity {

    @CreatedDate
    public LocalDateTime createDate;

    @CreatedBy
    public Long createdBy;

    @LastModifiedDate
    public LocalDateTime lastModifiedDate;

    @LastModifiedBy
    public Long lastModifiedBy;

    @Column
    private String ip;

    @PrePersist
    public void prePersist() {
        ip = IpFinderUtil.getClientIp();
    }

    @PreUpdate
    public void preUpdate() {
        ip = IpFinderUtil.getClientIp();
    }
}
