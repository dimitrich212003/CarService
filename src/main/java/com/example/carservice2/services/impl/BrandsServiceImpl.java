package com.example.carservice2.services.impl;

import com.example.carservice2.services.dto.BrandsDTO;
import com.example.carservice2.models.Brands;
import com.example.carservice2.repositories.BrandsRepository;
import com.example.carservice2.services.BrandsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BrandsServiceImpl implements BrandsService {
    private final BrandsRepository brandsRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public BrandsServiceImpl(BrandsRepository brandsRepository, ModelMapper modelMapper) {
        this.brandsRepository = brandsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BrandsDTO createBrand(BrandsDTO brandsDTO) {
        Brands brand = modelMapper.map(brandsDTO, Brands.class);
        Brands createBrand = brandsRepository.saveAndFlush(brand);
        System.out.println("Бренд " + createBrand.getName() + "  " + createBrand.getId() + "сохранен");
        return modelMapper.map(createBrand, BrandsDTO.class);
    }

    @Override
    public BrandsDTO updateBrand(UUID id, BrandsDTO brandsDTO) {
        Brands brand = brandsRepository.findById(id).orElseThrow(() -> new RuntimeException("Brand not found"));

        brand.setName(brandsDTO.getName());
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
}
