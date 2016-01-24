package com.service;

import com.model.Apartment;

import java.util.List;

/**
 * Created by Kyza on 23.01.2016.
 */
public interface ApartmentServices {
    Apartment addApartment(Apartment apartment);
    void delete(long id);
    Apartment getByApartment(String apartment);
    List<Apartment> getAll();
}
