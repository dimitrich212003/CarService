//package com.example.carservice2.controllers;
//
//import com.example.carservice2.repositories.BrandsRepository;
//import com.example.carservice2.services.BrandsService;
//import com.example.carservice2.services.dto.BrandsDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//public class BrandsController {
//    private BrandsService brandsService;
//
//    @Autowired
//    public void setBrandsService(BrandsService brandsService) {
//        this.brandsService = brandsService;
//    }
//
//    @GetMapping("/brands")
//    public List<BrandsDTO> getAllBrands() {
//        return brandsService.getAllBrands();
//    }
//
//    @PostMapping("/brands")
//    public ResponseEntity<BrandsDTO> createBrand(@RequestBody BrandsDTO brandDTO) {
//        BrandsDTO createdBrand = brandsService.createBrand(brandDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdBrand);
//    }
//
//    //GetBrandById
//    @GetMapping("/brands/{id}")
//    public BrandsDTO getBrandById(@PathVariable UUID id) {
//        return brandsService.getBrandById(id);
//    }
//
//    //GetBrandByName
//    @GetMapping("/brands/name/{name}")
//    public BrandsDTO getBrandByName(@PathVariable String name){
//        return brandsService.getBrandByName(name);
//    }
//
//    // DeleteBrandById
//    @DeleteMapping("/brands/{id}")
//    public void deleteBrandByID(@PathVariable UUID id) {
//        brandsService.deleteBrand(id);
//    }
//
//    //UpdateBrand
//    @PutMapping("/brands/update/{id}")
//    public BrandsDTO updateBrand(@PathVariable UUID id, @RequestBody BrandsDTO brandsDTO) {
//        return brandsService.updateBrand(id, brandsDTO);
//    }
//}
