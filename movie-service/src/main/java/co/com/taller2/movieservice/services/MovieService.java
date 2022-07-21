package co.com.taller2.movieservice.services;

import co.com.taller2.movieservice.persistence.entity.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);

    List<Movie> findAll();

    List<Movie> findMovieById(Long id);

    void delete(Long id);
}
