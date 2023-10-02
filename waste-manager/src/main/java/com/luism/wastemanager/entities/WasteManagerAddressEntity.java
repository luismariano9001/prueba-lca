package com.luism.wastemanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "wastemanageraddress")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "base")
public class WasteManagerAddressEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "direccion")
    private String direccion;

    @JsonIgnore
    @OneToOne(mappedBy = "wasteManagerAddressEntity")
    WasteManagerEntity wasteManagerEntity;

    @Column(name = "isEnabled")
    private Boolean isEnabled;

    @Column(name = "version")
    private Long version;

    @Column(name = "createdate")
    private Date createdDate;
    @Column(name = "lastModifiedDate")
    private Date lastModifiedDate;

}
