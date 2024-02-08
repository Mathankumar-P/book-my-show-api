package com.api.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Screen  extends BaseModel{
    private String name;
    @ManyToOne
    private Theater theater;
    @OneToMany
    private List<Seat> seats;

}
