package com.example.carservice2.repositories;

import com.example.carservice2.models.Brands;
import com.example.carservice2.models.Offers;
import com.example.carservice2.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Query("SELECT u FROM users u JOIN u.offers o WHERE o.id = :offerId")
    Users findByOfferId(@Param("offerId") UUID offerId);

    Users getUsersByUsername(String username);
}
