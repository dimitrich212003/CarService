package com.example.carservice2.mapper.impl;

import com.example.carservice2.mapper.Mapper;
import com.example.carservice2.models.Brands;
import com.example.carservice2.models.Models;
import com.example.carservice2.repositories.BrandsRepository;
import com.example.carservice2.services.dto.ModelsDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarModelMapper implements Mapper<Models, ModelsDTO> {

    private final ModelMapper modelMapper;

    private final BrandsRepository brandsRepository;

    @Autowired
    public CarModelMapper(ModelMapper modelMapper, BrandsRepository brandsRepository) {
        this.modelMapper = modelMapper;
        this.brandsRepository = brandsRepository;

        TypeMap<Models, ModelsDTO> modelPropertyMapper = modelMapper.createTypeMap(Models.class, ModelsDTO.class);
        modelPropertyMapper.addMapping(
                model -> model.getBrand() != null ? model.getBrand().getId() : "brand not underfunded",
                ModelsDTO::setBrand

        );
    }

    @Override
    public Models toModel(ModelsDTO dto) {
        Models model = modelMapper.map(dto, Models.class);
        if (dto.getBrand() != null) {
            Brands brand = brandsRepository.findById(dto.getBrand()).orElseThrow(() -> new IllegalArgumentException("Invalid brand ID"));
            model.setBrand(brand);
        }
        return model;
    }

    @Override
    public ModelsDTO toDTO(Models model) {
        ModelsDTO dto = modelMapper.map(model, ModelsDTO.class);
//        System.out.println(model.getBrand().getId() + "мы в методе toDTO ЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫЫыы");
        if (model.getBrand() != null) {
            dto.setBrand(model.getBrand().getId());
        }
        return dto;
    }
}
