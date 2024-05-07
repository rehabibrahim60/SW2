package com.example.demo.Service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.example.demo.model.Advertisement;
import com.example.demo.repository.AdvertisementRepository;


    @Service
public class AdvertisementService {

    private final AdvertisementRepository advertisementRepository;

 
    public AdvertisementService(AdvertisementRepository advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    
    public List<Advertisement> getAllAdvertisements() {
        return advertisementRepository.findAll();
    }
}

