package com.example.carservice2.repositories;

import com.example.carservice2.models.Brands;
import com.example.carservice2.models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OffersRepository extends JpaRepository<Offers, UUID> {
    List<Offers> getOffersByModelId(UUID modelId);

    List<Offers> getOffersBySellerId(UUID userId);
}
