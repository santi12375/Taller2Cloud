package co.com.taller2.showtimeservice.model;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String title;
    private String director;
    private String rating;
}
