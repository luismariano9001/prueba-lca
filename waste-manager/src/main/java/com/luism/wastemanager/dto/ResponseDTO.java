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
public class ResponseDTO {

    private Object objectResponse;
    private String message;
    private int statusCode;
}
