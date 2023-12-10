package com.example.carservice2.services.impl;


import com.example.carservice2.mapper.impl.CarModelMapper;
import com.example.carservice2.mapper.impl.OfferMapper;
import com.example.carservice2.models.Offers;
import com.example.carservice2.repositories.BrandsRepository;
import com.example.carservice2.services.dto.ModelsDTO;
import com.example.carservice2.models.Models;
import com.example.carservice2.repositories.ModelsRepository;
import com.example.carservice2.services.ModelsService;
import com.example.carservice2.services.dto.OffersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelsServiceImpl implements ModelsService {

    private final ModelsRepository modelsRepository;
    private final CarModelMapper carModelMapper;
    private final OfferMapper offerMapper;
    private final BrandsRepository brandsRepository;

    @Autowired
    public ModelsServiceImpl(ModelsRepository modelsRepository, CarModelMapper carModelMapper, OfferMapper offerMapper, BrandsRepository brandsRepository) {
        this.modelsRepository = modelsRepository;
        this.carModelMapper = carModelMapper;
        this.offerMapper = offerMapper;
        this.brandsRepository = brandsRepository;
    }

    @Override
    public ModelsDTO createModel(ModelsDTO modelDto) {
        Models model = carModelMapper.toModel(modelDto);
        model.setCreated(LocalDate.now());
        Models createdModel = modelsRepository.saveAndFlush(model);
        return carModelMapper.toDTO(createdModel);
    }

    @Override
    public ModelsDTO updateModel(UUID id, ModelsDTO modelDto) {
        Models model = modelsRepository.findById(id).orElseThrow(() -> new RuntimeException("Model not found"));

        model.setName(modelDto.getName());
        model.setCategory(Models.CategoryType.valueOf(String.valueOf(modelDto.getCategory())));
        model.setImageUrl(modelDto.getImageUrl());
        model.setStartYear(modelDto.getStartYear());
        model.setEndYear(modelDto.getEndYear());
        model.setModified(LocalDate.now());

        Models updatedModel = modelsRepository.saveAndFlush(model);
        return carModelMapper.toDTO(updatedModel);
    }

    @Override
    public void deleteModel(UUID id) {
        modelsRepository.deleteById(id);
    }

    @Override
    public ModelsDTO getModelById(UUID id) {
        Models model = modelsRepository.findById(id).orElseThrow(() -> new RuntimeException("Model not found"));
        return carModelMapper.toDTO(model);
    }

    @Override
    public List<ModelsDTO> getAllModels() {
        List<Models> models = modelsRepository.findAll();
        return models.stream()
                .map(model -> carModelMapper.toDTO(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelsDTO> getModelsByBrandId(UUID brandId) {
        List<Models> models = modelsRepository.getModelsByBrand_Id(brandId);
        return models.stream()
                .map(model -> carModelMapper.toDTO(model))
                .collect(Collectors.toList());
    }

    @Override
    public List<ModelsDTO> getModelsByOffers(List<OffersDTO> offersDTO){
        List<Models> models = new ArrayList<>();
        List<Offers> offers = offersDTO.stream()
                .map(offerDto -> offerMapper.toModel(offerDto))
                .collect(Collectors.toList());
        for(Offers offer : offers) {
            Models model = offer.getModel();
            if (model != null) {
                models.add(model);
            }
        }
        return models.stream()
                .map(model -> carModelMapper.toDTO(model))
                .collect(Collectors.toList());
    }

    @Override
    public ModelsDTO findByOfferId(UUID offerId) {
        Models model = modelsRepository.findByOfferId(offerId);
        return carModelMapper.toDTO(model);
    }
}
