//package com.example.carservice2.controllers;
//
//import com.example.carservice2.services.ModelsService;
//import com.example.carservice2.services.dto.BrandsDTO;
//import com.example.carservice2.services.dto.ModelsDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//public class ModelsController {
//    private ModelsService modelsService;
//
//    @Autowired
//    public void setModelsService(ModelsService modelsService) {
//        this.modelsService = modelsService;
//    }
//
//    @GetMapping("/models")
//    public List<ModelsDTO> getAllModels() {
//        return modelsService.getAllModels();
//    }
//
//    @PostMapping("/models")
//    public ResponseEntity<ModelsDTO> createModel(@RequestBody ModelsDTO modelsDTO) {
//        ModelsDTO createModel = modelsService.createModel(modelsDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createModel);
//    }
//
//    @GetMapping("/models/{id}")
//    public ModelsDTO getModelById(@PathVariable UUID id) {
//        return modelsService.getModelById(id);
//    }
//
//    @DeleteMapping("/models/{id}")
//    public void deleteModelByID(@PathVariable UUID id) {
//        modelsService.deleteModel(id);
//    }
//
//    @PutMapping("/models/update/{id}")
//    public ModelsDTO updateModel(@PathVariable UUID id, @RequestBody ModelsDTO modelsDTO) {
//        return modelsService.updateModel(id, modelsDTO);
//    }
//
//}
