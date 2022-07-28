package co.com.taller2.movieservice.services;

import co.com.taller2.movieservice.persistence.entity.Movie;
import co.com.taller2.movieservice.persistence.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(long id) {
        movieRepository.deleteMovieById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Movie findMovieById(long id) {
        return movieRepository.findMovieById(id);
    }
}
