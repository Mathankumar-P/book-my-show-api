package com.api.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Theater extends BaseModel{
 private String name;
 private String address;
 @ManyToOne
 private Region region;
}
