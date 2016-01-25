package com.service.impl;

import com.model.ReservationDate;
import com.repository.ReservDataRepo;
import com.service.ReservDataServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Kyza on 25.01.2016.
 */
@Service
public class ReservationImpl implements ReservDataServices {

    @Autowired
    ReservDataRepo reservDataRepo;

    @Override
    public ReservationDate addReservationDate(ReservationDate reservationDate) {
        ReservationDate saveddate = reservDataRepo.saveAndFlush(reservationDate);
        return saveddate;
    }

    @Override
    public void delete(long id) {reservDataRepo.delete(id);

    }

    @Override
    public ReservationDate getByDate(ReservationDate reservationDate) {
        return reservDataRepo.saveAndFlush(reservationDate);
    }

    @Override
    public List<ReservationDate> getAll() {
        return reservDataRepo.findAll();
    }
}
