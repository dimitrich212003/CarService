package com.example.carservice2.services.impl;

import com.example.carservice2.mapper.impl.CarModelMapper;
import com.example.carservice2.models.Models;
import com.example.carservice2.services.dto.BrandsDTO;
import com.example.carservice2.models.Brands;
import com.example.carservice2.repositories.BrandsRepository;
import com.example.carservice2.services.BrandsService;
import com.example.carservice2.services.dto.ModelsDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandsServiceImpl implements BrandsService {
    private final BrandsRepository brandsRepository;
    private final ModelMapper modelMapper;

    private final CarModelMapper carModelMapper;

    @Autowired
    public BrandsServiceImpl(BrandsRepository brandsRepository, ModelMapper modelMapper, CarModelMapper carModelMapper) {
        this.brandsRepository = brandsRepository;
        this.modelMapper = modelMapper;
        this.carModelMapper = carModelMapper;
    }

    @Override
    public BrandsDTO createBrand(BrandsDTO brandsDTO) {
        Brands brand = modelMapper.map(brandsDTO, Brands.class);
        brand.setCreated(LocalDate.now());
        Brands createBrand = brandsRepository.saveAndFlush(brand);
        return modelMapper.map(createBrand, BrandsDTO.class);
    }

    @Override
    public BrandsDTO updateBrand(UUID id, BrandsDTO brandsDTO) {
        Brands brand = brandsRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand" + id + "not found"));
        brand.setName(brandsDTO.getName());
        brand.setModified(LocalDate.now());
        Brands updateBrand = brandsRepository.saveAndFlush(brand);
        return modelMapper.map(updateBrand, BrandsDTO.class);
    }

    @Override
    public void deleteBrand(UUID id) {
        brandsRepository.deleteById(id);
    }

    @Override
    public BrandsDTO getBrandById(UUID id) {
        Brands brand = brandsRepository.findById(id).orElseThrow(() -> new RuntimeException("brand not found"));
        return modelMapper.map(brand, BrandsDTO.class);
    }

    @Override
    public List<BrandsDTO> getAllBrands() {
        List<Brands> brands = brandsRepository.findAll();
        return brands.stream()
                .map((brand) -> modelMapper.map(brand, BrandsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BrandsDTO getBrandByName(String name) {
        Brands brand = brandsRepository.getBrandsByName(name);
        return modelMapper.map(brand, BrandsDTO.class);
    }

    @Override
    public BrandsDTO findByModelId(UUID modelId) {
        Brands brand = brandsRepository.findByModelId(modelId);
        return modelMapper.map(brand, BrandsDTO.class);
    }

    @Override
    public List<BrandsDTO> getBrandsByModels(List<ModelsDTO> modelsDTO) {
        List<Brands> brands = new ArrayList<>();
        List<Models> models = modelsDTO.stream()
                .map(modelDTO -> carModelMapper.toModel(modelDTO))
                .collect(Collectors.toList());
        for(Models model : models) {
            Brands brand = model.getBrand();
            if(brand != null) {
                brands.add(brand);
            }
        }
        return brands.stream()
                .map(brand -> modelMapper.map(brand, BrandsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public BrandsDTO getBrandByModel(ModelsDTO modelDTO) {
        Models model = carModelMapper.toModel(modelDTO);
        Brands brand = model.getBrand();
        return modelMapper.map(brand, BrandsDTO.class);
    }
}
