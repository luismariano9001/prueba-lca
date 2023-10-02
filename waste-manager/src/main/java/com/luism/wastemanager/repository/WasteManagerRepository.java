package com.luism.wastemanager.repository;

import com.luism.wastemanager.entities.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerRepository extends JpaRepository<WasteManagerEntity, Long> {


}
