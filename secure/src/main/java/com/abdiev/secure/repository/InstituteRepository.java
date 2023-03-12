package com.abdiev.secure.repository;

import com.abdiev.secure.model.Institute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstituteRepository extends JpaRepository<Institute,Long> {
    @Query("SELECT u.name FROM Institute u")
    List<String> findAllNames();
}
