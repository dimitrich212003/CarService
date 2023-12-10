package com.example.carservice2.services.impl;

import com.example.carservice2.mapper.impl.OfferMapper;
import com.example.carservice2.services.dto.OffersDTO;
import com.example.carservice2.models.Offers;
import com.example.carservice2.repositories.OffersRepository;
import com.example.carservice2.services.OffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OffersServiceImpl implements OffersService {

    private final OffersRepository offersRepository;

    private final OfferMapper offerMapper;

    @Autowired
    public OffersServiceImpl(OffersRepository offersRepository, OfferMapper offerMapper) {
        this.offersRepository = offersRepository;
        this.offerMapper = offerMapper;
    }

    @Override
    public OffersDTO createOffer(OffersDTO offerDto) {
        Offers offer = offerMapper.toModel(offerDto);
        offer.setCreated(LocalDate.now());
        Offers createdOffer = offersRepository.saveAndFlush(offer);
        return offerMapper.toDTO(createdOffer);
    }

    @Override
    public OffersDTO updateOffer(UUID id, OffersDTO offerDto) {
        Offers offer = offersRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));

        offer.setDescription(offerDto.getDescription());
        offer.setEngine(Offers.EngineType.valueOf(String.valueOf(offerDto.getEngine())));
        offer.setImageUrl(offerDto.getImageUrl());
        offer.setMileage(offerDto.getMileage());
        offer.setPrice(offerDto.getPrice());
        offer.setTransmission(Offers.TransmissionType.valueOf(String.valueOf(offerDto.getTransmission())));
        offer.setYear(offerDto.getYear());
        offer.setModified(LocalDate.now());

        Offers updatedOffer = offersRepository.saveAndFlush(offer);
        return offerMapper.toDTO(updatedOffer);
    }

    @Override
    public void deleteOffer(UUID id) {
        offersRepository.deleteById(id);
    }

    @Override
    public OffersDTO getOfferById(UUID id) {
        Offers offer = offersRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));
        return offerMapper.toDTO(offer);
    }

    @Override
    public List<OffersDTO> getAllOffers() {
        List<Offers> offers = offersRepository.findAll();
        return offers.stream()
                .map(offer -> offerMapper.toDTO(offer))
                .collect(Collectors.toList());
    }

    @Override
    public List<OffersDTO> getOffersByModelId(UUID modelId) {
        List<Offers> offers = offersRepository.getOffersByModelId(modelId);
        return offers.stream()
                .map(offer -> offerMapper.toDTO(offer))
                .collect(Collectors.toList());
    }

    @Override
    public List<OffersDTO> getOffersByUserId(UUID userId) {
        List<Offers> offers = offersRepository.getOffersBySellerId(userId);
        return offers.stream()
                .map(offer -> offerMapper.toDTO(offer))
                .collect(Collectors.toList());
    }

}
