package com.example.carservice2.services.impl;

import com.example.carservice2.services.dto.OffersDTO;
import com.example.carservice2.models.Offers;
import com.example.carservice2.repositories.OffersRepository;
import com.example.carservice2.services.OffersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OffersServiceImpl implements OffersService {

    private final OffersRepository offersRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public OffersServiceImpl(OffersRepository offersRepository, ModelMapper modelMapper) {
        this.offersRepository = offersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OffersDTO createOffer(OffersDTO offerDto) {
        Offers offer = modelMapper.map(offerDto, Offers.class);
        Offers createdOffer = offersRepository.saveAndFlush(offer);
        return modelMapper.map(createdOffer, OffersDTO.class);
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

        Offers updatedOffer = offersRepository.save(offer);
        return modelMapper.map(updatedOffer, OffersDTO.class);
    }

    @Override
    public void deleteOffer(UUID id) {
        offersRepository.deleteById(id);
    }

    @Override
    public OffersDTO getOfferById(UUID id) {
        Offers offer = offersRepository.findById(id).orElseThrow(() -> new RuntimeException("Offer not found"));
        return modelMapper.map(offer, OffersDTO.class);
    }

    @Override
    public List<OffersDTO> getAllOffers() {
        List<Offers> offers = offersRepository.findAll();
        return offers.stream()
                .map(offer -> modelMapper.map(offer, OffersDTO.class))
                .collect(Collectors.toList());
    }
}
