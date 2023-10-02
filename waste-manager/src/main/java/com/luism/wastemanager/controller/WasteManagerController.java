package com.luism.wastemanager.controller;

import com.luism.wastemanager.dto.WasteManagerDTO;
import com.luism.wastemanager.entities.WasteManagerEntity;
import com.luism.wastemanager.service.WasteManagerService.IWasteManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/wastemanager")
public class WasteManagerController {

    @Autowired
    IWasteManagerService iWasteManagerService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody WasteManagerDTO wm) throws ParseException {

        System.out.println(wm);
        return iWasteManagerService.postWasteManager(wm);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody WasteManagerDTO wm) throws ParseException {

        System.out.println(wm);
        return iWasteManagerService.putWasteManager(wm);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id){

        return iWasteManagerService.getWasteManager(id);
    }

}
