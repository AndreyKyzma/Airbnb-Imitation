package com.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Kyza on 21.01.2016.
 */
@Entity
@Table(name = "apartament")
public class Apartment {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ApartmentType apartmentType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "User_id", nullable = false)
    private User user;




    public Apartment(String city, ApartmentType apartmentType,  ReservationDate reservationDate) {
        this.city = city;
        this.apartmentType = apartmentType;


    }

    public Apartment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", apartmentType=" + apartmentType +
                ", user=" + user +
//                ", reservationDate=" + reservationDate +
                '}';
    }

}
