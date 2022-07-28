package co.com.taller2.movieservice.services;

import co.com.taller2.movieservice.persistence.entity.Movie;

import java.util.List;

public interface MovieService {

    void save(Movie movie);

    void delete(long id);

    List<Movie> findAllMovies();

    Movie findMovieById(long id);
}
