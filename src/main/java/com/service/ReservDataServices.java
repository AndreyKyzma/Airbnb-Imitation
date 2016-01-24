package com.service;

import com.model.ReservationDate;

import java.util.List;

/**
 * Created by Kyza on 23.01.2016.
 */
public interface ReservDataServices {
    ReservationDate addReservationDate(ReservationDate reservationDate);
    void delete(long id);
    ReservationDate getByDate(String name);
    ReservationDate editDate(ReservationDate reservationDate);
    List<ReservationDate> getAll();

}
