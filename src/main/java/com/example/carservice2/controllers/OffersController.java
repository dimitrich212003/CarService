package com.example.carservice2.controllers;

import com.example.carservice2.services.OffersService;
import com.example.carservice2.services.dto.OffersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class OffersController {

    private OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

//    @GetMapping("/offers")
//    public List<OffersDTO> getAllModels() {
//        return offersService.getAllOffers();
//    }
//
//    @PostMapping("/offers")
//    public ResponseEntity<OffersDTO> createOffer(@RequestBody OffersDTO offersDTO) {
//        OffersDTO createOffer = offersService.createOffer(offersDTO);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createOffer);
//    }
//
//    @GetMapping("/offers/{id}")
//    public OffersDTO getOfferById(@PathVariable UUID id) {
//        return offersService.getOfferById(id);
//    }
//
//    @DeleteMapping("/offers/{id}")
//    public void deleteOfferByID(@PathVariable UUID id) {
//        offersService.deleteOffer(id);
//    }
//
//    @PutMapping("/offers/update/{id}")
//    public OffersDTO updateOffer(@PathVariable UUID id, @RequestBody OffersDTO offersDTO) {
//        return offersService.updateOffer(id, offersDTO);
//    }
}
