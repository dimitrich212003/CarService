package com.example.carservice2.repositories;

import com.example.carservice2.models.Brands;
import com.example.carservice2.models.Models;
import com.example.carservice2.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ModelsRepository extends JpaRepository<Models, UUID> {
    List<Models> getModelsByBrand_Id(UUID brandId);

    @Query("SELECT m FROM Models m JOIN m.offers o WHERE o.id = :offerId")
    Models findByOfferId(@Param("offerId") UUID offerId);
}
