package com.luism.wastemanager.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WasteManagerDTO {

    private Long id;
    private WasteManagerAddressDTO wasteManagerAddress;
    private String nombre;
    private String nif;
    private Boolean isEnabled;
    private Long version;
    private Date createdDate;
    private Date lastModifiedDate;
}
