package com.example.carservice2.repositories;

import com.example.carservice2.models.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OffersRepository extends JpaRepository<Offers, UUID> {
}
