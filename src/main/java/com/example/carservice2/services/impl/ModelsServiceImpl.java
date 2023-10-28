package com.example.carservice2.services.impl;


import com.example.carservice2.services.dto.ModelsDTO;
import com.example.carservice2.models.Models;
import com.example.carservice2.repositories.ModelsRepository;
import com.example.carservice2.services.ModelsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelsServiceImpl implements ModelsService {

    private final ModelsRepository modelsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ModelsServiceImpl(ModelsRepository modelsRepository, ModelMapper modelMapper) {
        this.modelsRepository = modelsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelsDTO createModel(ModelsDTO modelDto) {
        Models model = modelMapper.map(modelDto, Models.class);
        Models createdModel = modelsRepository.saveAndFlush(model);
        return modelMapper.map(createdModel, ModelsDTO.class);
    }

    @Override
    public ModelsDTO updateModel(UUID id, ModelsDTO modelDto) {
        Models model = modelsRepository.findById(id).orElseThrow(() -> new RuntimeException("Model not found"));

        model.setName(modelDto.getName());
        model.setCategory(Models.CategoryType.valueOf(String.valueOf(modelDto.getCategory())));
        model.setImageUrl(modelDto.getImageUrl());
        model.setStartYear(modelDto.getStartYear());
        model.setEndYear(modelDto.getEndYear());

        Models updatedModel = modelsRepository.save(model);
        return modelMapper.map(updatedModel, ModelsDTO.class);
    }

    @Override
    public void deleteModel(UUID id) {
        modelsRepository.deleteById(id);
    }

    @Override
    public ModelsDTO getModelById(UUID id) {
        Models model = modelsRepository.findById(id).orElseThrow(() -> new RuntimeException("Model not found"));
        return modelMapper.map(model, ModelsDTO.class);
    }

    @Override
    public List<ModelsDTO> getAllModels() {
        List<Models> models = modelsRepository.findAll();
        return models.stream()
                .map(model -> modelMapper.map(model, ModelsDTO.class))
                .collect(Collectors.toList());
    }
}
