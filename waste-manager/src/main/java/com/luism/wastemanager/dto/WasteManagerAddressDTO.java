package com.luism.wastemanager.dto;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WasteManagerAddressDTO {

    private Long id;
    private String direccion;
    private Boolean isEnabled;
    private Long version;
    private Date createdDate;
    private Date lastModifiedDate;
}
