package co.com.taller2.movieservice.services;

import co.com.taller2.movieservice.persistence.entity.Movie;
import co.com.taller2.movieservice.persistence.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    MovieRepository movieRepository;

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findMovieById(Long id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteMovieById(id);
    }


}
