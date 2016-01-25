package com.Utill;

import com.model.ReservationDate;

import java.util.Date;

/**
 * Created by Kyza on 25.01.2016.
 */
public class ReservDataUtill {

    public static ReservationDate createDate() {
        ReservationDate reservationDate = new ReservationDate();
        reservationDate.setStartReservation(new Date());


        return reservationDate;
    }
}
