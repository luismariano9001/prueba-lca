package com.luism.wastemanager.service.WasteManagerService;

import com.luism.wastemanager.dto.WasteManagerDTO;
import com.luism.wastemanager.entities.WasteManagerEntity;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;

public interface IWasteManagerService {

    ResponseEntity<?> postWasteManager(WasteManagerDTO wmDTO) throws ParseException;

    ResponseEntity<?> getWasteManager(Long idWasteManager);

    ResponseEntity<?> putWasteManager(WasteManagerDTO wmDTO);
}
