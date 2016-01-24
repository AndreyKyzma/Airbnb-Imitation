package com.repository;

import com.model.ReservationDate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Kyza on 22.01.2016.
 */
public interface ReservDataRepo extends JpaRepository<ReservationDate, Long> {
}
