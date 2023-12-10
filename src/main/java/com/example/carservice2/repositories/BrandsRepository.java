package com.example.carservice2.repositories;

import com.example.carservice2.models.Brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrandsRepository extends JpaRepository<Brands, UUID> {
    Brands getBrandsByName(String name);

    @Query("SELECT b FROM Brands b JOIN b.models m WHERE m.id = :modelId")
    Brands findByModelId(@Param("modelId") UUID modelId);
}
