package com.repository;

import com.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kyza on 22.01.2016.
 */
public interface ApartmentRepo extends JpaRepository<Apartment, Long> {
}
