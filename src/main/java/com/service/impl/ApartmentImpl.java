package com.service.impl;

import com.model.Apartment;
import com.repository.ApartmentRepo;
import com.service.ApartmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kyza on 25.01.2016.
 */
@Service
public class ApartmentImpl implements ApartmentServices {

    @Autowired
    ApartmentRepo apartmentRepo;

    @Override
    public Apartment addApartment(Apartment apartment) {
        Apartment saveApartment = apartmentRepo.saveAndFlush(apartment);
        return saveApartment;
    }


    @Override
    public void delete(long id) {apartmentRepo.delete(id);

    }

    @Override
    public Apartment editApartment(Apartment apartment) {
        return apartmentRepo.saveAndFlush(apartment);
    }


    @Override
    public List<Apartment> getAll() {
        return apartmentRepo.findAll();
    }
}
