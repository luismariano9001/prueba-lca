package com.luism.wastemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class WasteManagerSalidaDTO {

    private Long id;
    private String nombre;
    private String nif;
    private Address address;

    @RequiredArgsConstructor
    @AllArgsConstructor
    @Data
    public static class Address {
        private Long id;
        private String direccion;

    }

}




