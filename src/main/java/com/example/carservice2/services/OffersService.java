package com.example.carservice2.services;

import com.example.carservice2.services.dto.OffersDTO;

import java.util.List;
import java.util.UUID;

public interface OffersService {

    OffersDTO createOffer(OffersDTO offerDto);

    OffersDTO updateOffer(UUID id, OffersDTO offerDto);

    void deleteOffer(UUID id);

    OffersDTO getOfferById(UUID id);

    List<OffersDTO> getAllOffers();
}
