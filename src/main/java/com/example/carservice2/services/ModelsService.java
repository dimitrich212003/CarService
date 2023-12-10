package com.example.carservice2.services;

import com.example.carservice2.services.dto.ModelsDTO;
import com.example.carservice2.services.dto.OffersDTO;

import java.util.List;
import java.util.UUID;

public interface ModelsService {

    ModelsDTO createModel(ModelsDTO modelDto);

    ModelsDTO updateModel(UUID id, ModelsDTO modelDto);

    void deleteModel(UUID id);

    ModelsDTO getModelById(UUID id);

    List<ModelsDTO> getAllModels();

    List<ModelsDTO> getModelsByBrandId(UUID brandId);

    List<ModelsDTO> getModelsByOffers(List<OffersDTO> offersDTO);

    ModelsDTO findByOfferId(UUID offerId);
}
