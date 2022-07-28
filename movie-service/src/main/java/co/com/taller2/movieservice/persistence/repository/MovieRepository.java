package co.com.taller2.movieservice.persistence.repository;

import co.com.taller2.movieservice.persistence.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findMovieById(long id);

    void deleteMovieById(long id);
}
