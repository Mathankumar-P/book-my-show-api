package com.api.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;

@Entity
public class Region extends BaseModel {
    private String name;
    private double longitude;
    private double latitude;

    @OneToMany(mappedBy = "region")
    private List<Theater> theaterList;

}
