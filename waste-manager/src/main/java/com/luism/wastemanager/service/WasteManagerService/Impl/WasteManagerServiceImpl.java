package com.luism.wastemanager.service.WasteManagerService.Impl;

import com.luism.wastemanager.dto.ResponseDTO;
import com.luism.wastemanager.dto.WasteManagerAddressDTO;
import com.luism.wastemanager.dto.WasteManagerDTO;
import com.luism.wastemanager.dto.WasteManagerSalidaDTO;
import com.luism.wastemanager.entities.WasteManagerAddressEntity;
import com.luism.wastemanager.entities.WasteManagerEntity;
import com.luism.wastemanager.repository.WasteManagerAddressRepository;
import com.luism.wastemanager.repository.WasteManagerRepository;
import com.luism.wastemanager.service.WasteManagerService.IWasteManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WasteManagerServiceImpl implements IWasteManagerService {

    @Autowired
    WasteManagerRepository wasteManagerRepository;

    @Autowired
    WasteManagerAddressRepository wasteManagerAddressRepository;

    @Override
    public ResponseEntity<?> postWasteManager(WasteManagerDTO wmDTO) throws ParseException {

        WasteManagerAddressDTO wasteManagerAddressDTO = wmDTO.getWasteManagerAddress();

        WasteManagerAddressEntity addressEntity = WasteManagerAddressEntity.builder()
                                                                           .direccion(wasteManagerAddressDTO.getDireccion())
                                                                          .createdDate(wasteManagerAddressDTO.getCreatedDate())
                                                                          .lastModifiedDate(wasteManagerAddressDTO.getLastModifiedDate())
                                                                          .version(1L)
                                                                          .isEnabled(wasteManagerAddressDTO.getIsEnabled())
                                                                          .build();

        WasteManagerAddressEntity wmAddressSaved = wasteManagerAddressRepository.save(addressEntity);


        WasteManagerEntity wasteManagerEntity = WasteManagerEntity.builder().wasteManagerAddressEntity(wmAddressSaved)
                                                                            .nif(wmDTO.getNif())
                                                                            .version(1L)
                                                                            .nombre(wmDTO.getNombre())
                                                                            .createdDate(wmDTO.getCreatedDate())
                                                                            .lastModifiedDate(wmDTO.getLastModifiedDate())
                                                                            .isEnabled(wmDTO.getIsEnabled())
                                                                            .build();

        return new ResponseEntity<>(ResponseDTO.builder().objectResponse(wasteManagerRepository.save(wasteManagerEntity))
                                                         .message("WasteManager was created sucessfully.")
                                                         .statusCode(HttpStatus.CREATED.value()).build() , HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> getWasteManager(Long idWasteManager) {
        Optional<WasteManagerEntity> wasteManager = wasteManagerRepository.findById(idWasteManager);

        WasteManagerSalidaDTO salida = WasteManagerSalidaDTO.builder().build();
        if (!wasteManager.isEmpty()){
            WasteManagerSalidaDTO.Address address = new WasteManagerSalidaDTO.Address(wasteManager.get().getWasteManagerAddressEntity().getId(),wasteManager.get().getWasteManagerAddressEntity().getDireccion());
            salida.setAddress(address);
            salida.setId(wasteManager.get().getId());
            salida.setNif(wasteManager.get().getNif());
            salida.setNombre(wasteManager.get().getNombre());
        }else
            return new ResponseEntity<>(ResponseDTO.builder().message("WasteManager with id: "+idWasteManager + " not found.").statusCode(HttpStatus.NOT_FOUND.value()).build(),HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(ResponseDTO.builder().objectResponse(salida).message("Sucessfull operation.").statusCode(HttpStatus.OK.value()).build(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> putWasteManager(WasteManagerDTO wmDTO) {
        if (Objects.isNull(wmDTO.getId()))
            return new ResponseEntity<>(ResponseDTO.builder().message("You must send the id.").statusCode(HttpStatus.NOT_FOUND.value()).build(),HttpStatus.NOT_FOUND);

        Optional<WasteManagerEntity> wasteManager = wasteManagerRepository.findById(wmDTO.getId());

        if (!wasteManager.isEmpty()){
            WasteManagerEntity wmEntity = wasteManager.get();
            if (!Objects.isNull(wmDTO.getNombre()))
                wmEntity.setNombre(wmDTO.getNombre());
            if (!Objects.isNull(wmDTO.getNif()))
                wmEntity.setNif(wmDTO.getNif());
            if (!Objects.isNull(wmDTO.getVersion()))
                wmEntity.setVersion(wmDTO.getVersion());
            if (!Objects.isNull(wmDTO.getCreatedDate()))
                wmEntity.setCreatedDate(wmDTO.getCreatedDate());
            if (!Objects.isNull(wmDTO.getLastModifiedDate()))
                wmEntity.setLastModifiedDate(wmDTO.getLastModifiedDate());
            if (!Objects.isNull(wmDTO.getIsEnabled()))
                wmEntity.setIsEnabled(wmDTO.getIsEnabled());

            if (!Objects.isNull(wmDTO.getWasteManagerAddress())){
                WasteManagerAddressDTO addressDTO = wmDTO.getWasteManagerAddress();
                if (!Objects.isNull(addressDTO.getDireccion()))
                    wmEntity.getWasteManagerAddressEntity().setDireccion(addressDTO.getDireccion());
                if (!Objects.isNull(addressDTO.getVersion()))
                    wmEntity.getWasteManagerAddressEntity().setVersion(addressDTO.getVersion());
                if (!Objects.isNull(addressDTO.getCreatedDate()))
                    wmEntity.getWasteManagerAddressEntity().setCreatedDate(addressDTO.getCreatedDate());
                if (!Objects.isNull(addressDTO.getLastModifiedDate()))
                    wmEntity.getWasteManagerAddressEntity().setLastModifiedDate(addressDTO.getLastModifiedDate());
                if (!Objects.isNull(addressDTO.getIsEnabled()))
                    wmEntity.getWasteManagerAddressEntity().setIsEnabled(addressDTO.getIsEnabled());

            }

            WasteManagerEntity wasteManagerEntitySaved = wasteManagerRepository.saveAndFlush(wmEntity);

            return new ResponseEntity<>(ResponseDTO.builder().objectResponse(wasteManagerEntitySaved)
                                                             .message("WasteManager was updated sucessfully.")
                                                             .statusCode(HttpStatus.OK.value()).build() ,HttpStatus.OK);
        }

        return new ResponseEntity<>(ResponseDTO.builder().message("WasteManager with id: "+wmDTO.getId() + " not found.").statusCode(HttpStatus.NOT_FOUND.value()).build(),HttpStatus.NOT_FOUND);
    }


}
