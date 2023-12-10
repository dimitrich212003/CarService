package com.example.carservice2.services;

import com.example.carservice2.services.dto.BrandsDTO;
import com.example.carservice2.services.dto.ModelsDTO;

import java.util.List;
import java.util.UUID;

public interface BrandsService {
    BrandsDTO createBrand(BrandsDTO brandsDTO);

    BrandsDTO updateBrand(UUID id, BrandsDTO brandsDTO);

    void deleteBrand(UUID id);

    BrandsDTO getBrandById(UUID id);

    List<BrandsDTO> getAllBrands();

    BrandsDTO getBrandByName(String name);

    BrandsDTO findByModelId(UUID modelId);

    List<BrandsDTO> getBrandsByModels(List<ModelsDTO> modelsDTO);

    BrandsDTO getBrandByModel(ModelsDTO modelDTO);
}
