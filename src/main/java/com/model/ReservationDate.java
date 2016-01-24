package com.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kyza on 21.01.2016.
 */
@Entity

public class ReservationDate {

    @Column(name = "startReservation")
    @Temporal(TemporalType.DATE)
    private Date startReservation;

    @Column(name = "endReservation")
    @Temporal(TemporalType.DATE)
    private Date endReservation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "apartamentId", nullable = false)
    private Apartment apartment;



    public ReservationDate(Date startReservation, Date endReservation, Apartment Apartment) {
        this.startReservation = startReservation;
        this.endReservation = endReservation;
        this.apartment = apartment;
    }

    public ReservationDate() {
    }

    public Date getStartReservation() {
        return startReservation;
    }

    public void setStartReservation(Date startReservation) {
        this.startReservation = startReservation;
    }

    public Date getEndReservation() {
        return endReservation;
    }

    public void setEndReservation(Date endReservation) {
        this.endReservation = endReservation;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "ReservationDate{" +
                "startReservation=" + startReservation +
                ", endReservation=" + endReservation +
                '}';
    }
}
