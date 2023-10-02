package com.luism.wastemanager.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "wastemanager")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "base")
public class WasteManagerEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "nif")
    private String nif;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idWasteManagerAddress", referencedColumnName = "id")
    private WasteManagerAddressEntity wasteManagerAddressEntity;
    @Column(name = "isEnabled")
    private Boolean isEnabled;
    @Column(name = "version")
    private Long version;
    @Column(name = "createdate")
    private Date createdDate;
    @Column(name = "lastModifiedDate")
    private Date lastModifiedDate;


}
