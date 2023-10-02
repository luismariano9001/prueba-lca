package com.luism.wastemanager.repository;

import com.luism.wastemanager.entities.WasteManagerAddressEntity;
import com.luism.wastemanager.entities.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerAddressRepository extends JpaRepository<WasteManagerAddressEntity, Long> {


}
