package com.api.bookmyshow.model;

import jakarta.annotation.security.DenyAll;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "movies")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Movie extends BaseModel {
    private String name;
    private String language;
    private double rating;
    private int duration;
    private String category;

    @Override
    public String toString() {
        return "Movie{" +
                "id"+this.getId()+","+
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                '}';
    }
}
