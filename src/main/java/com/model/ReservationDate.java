package com.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Kyza on 21.01.2016.
 */
@Entity
@Table(name = "reservationdate")
public class ReservationDate {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "date_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startReservation;

    @Column(name = "date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endReservation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "Apartment_id")
    private Apartment apartment;



    public ReservationDate(Date startReservation, Date endReservation) {
        this.startReservation = startReservation;
        this.endReservation = endReservation;

    }

    public ReservationDate() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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



    @Override
    public String toString() {
        return "ReservationDate{" +
                "startReservation=" + startReservation +
                ", endReservation=" + endReservation +
                '}';
    }
}
