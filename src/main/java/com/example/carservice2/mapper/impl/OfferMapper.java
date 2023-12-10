package com.example.carservice2.mapper.impl;

import com.example.carservice2.mapper.Mapper;
import com.example.carservice2.models.Models;
import com.example.carservice2.models.Offers;
import com.example.carservice2.models.Users;
import com.example.carservice2.repositories.ModelsRepository;
import com.example.carservice2.repositories.UsersRepository;
import com.example.carservice2.services.dto.OffersDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OfferMapper implements Mapper<Offers, OffersDTO> {

    private final ModelMapper modelMapper;
    private final ModelsRepository modelsRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public OfferMapper(ModelMapper modelMapper, ModelsRepository modelsRepository, UsersRepository usersRepository) {
        this.modelMapper = modelMapper;
        this.modelsRepository = modelsRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Offers toModel(OffersDTO dto) {
        Offers offer = modelMapper.map(dto, Offers.class);
        if (dto.getModel() != null) {
            Models model = modelsRepository.findById(dto.getModel()).orElseThrow(() -> new IllegalArgumentException("Invalid model ID"));
            offer.setModel(model);
        }
        if (dto.getUser() != null) {
            Users user = usersRepository.findById(dto.getUser()).orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
            offer.setSeller(user);
        }
        return offer;
    }

    @Override
    public OffersDTO toDTO(Offers offer) {
        OffersDTO dto = modelMapper.map(offer, OffersDTO.class);
        if (offer.getModel() != null) {
            dto.setModel(offer.getModel().getId());
        }
        if (offer.getSeller() != null) {
            dto.setUser(offer.getSeller().getId());
        }
        return dto;
    }
}
