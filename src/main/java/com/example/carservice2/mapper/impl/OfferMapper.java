package com.example.carservice2.mapper.impl;

import com.example.carservice2.mapper.Mapper;
import com.example.carservice2.models.Brands;
import com.example.carservice2.models.Models;
import com.example.carservice2.models.Offers;
import com.example.carservice2.repositories.ModelsRepository;
import com.example.carservice2.services.dto.ModelsDTO;
import com.example.carservice2.services.dto.OffersDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OfferMapper implements Mapper<Offers, OffersDTO> {

    private final ModelMapper modelMapper;
    private final ModelsRepository modelsRepository;

    @Autowired
    public OfferMapper(ModelMapper modelMapper, ModelsRepository modelsRepository) {
        this.modelMapper = modelMapper;
        this.modelsRepository = modelsRepository;

        TypeMap<Offers, OffersDTO> modelPropertyMapper = modelMapper.createTypeMap(Offers.class, OffersDTO.class);
        modelPropertyMapper.addMapping(
                offer -> offer.getModel() != null ? offer.getModel().getId() : "Model not underfunded",
                OffersDTO::setModel
        );
    }

    @Override
    public Offers toModel(OffersDTO dto) {
        Offers offer = modelMapper.map(dto, Offers.class);
        if (dto.getModel() != null) {
            Models model = modelsRepository.findById(dto.getModel()).orElseThrow(() -> new IllegalArgumentException("Invalid model ID"));
            offer.setModel(model);
        }
        return offer;
    }

    @Override
    public OffersDTO toDTO(Offers offer) {
        OffersDTO dto = modelMapper.map(offer, OffersDTO.class);
        System.out.println(offer.getModel().getId() + "мы в методе toDTO ЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫыы");
        if (offer.getModel() != null) {
            dto.setModel(offer.getModel().getId());
        }
        return dto;
    }
}
