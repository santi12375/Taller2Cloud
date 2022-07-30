package co.com.taller2.movieservice;

import co.com.taller2.movieservice.persistence.entity.Movie;
import co.com.taller2.movieservice.persistence.repository.MovieRepository;
import co.com.taller2.movieservice.services.MovieService;
import co.com.taller2.movieservice.services.MovieServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MovieServiceMock {

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private MovieService movieService;

    @BeforeEach
    public void projectServiceTest(){
        MockitoAnnotations.openMocks(this);
        movieService = new MovieServiceImpl(movieRepository);

        Movie user= Movie.builder()
                .title("Test Project")
                .director("Test Director")
                .rating(5)
                .build();
        List<Movie> movies = movieService.findAllMovies();
        movies.add(user);
        Mockito.when(movies).thenReturn(movies);
    }

    @Test
    public void when_findProject_return_Project(){
        List<Movie> users = movieService.findAllMovies();;
        Assertions.assertThat(users.size()).isEqualTo(1);
    }

}