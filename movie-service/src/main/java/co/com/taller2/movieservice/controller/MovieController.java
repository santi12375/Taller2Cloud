package co.com.taller2.movieservice.controller;

import co.com.taller2.movieservice.commons.FormatParser;
import co.com.taller2.movieservice.commons.Response;
import co.com.taller2.movieservice.commons.ResponseBuild;
import co.com.taller2.movieservice.persistence.entity.Movie;
import co.com.taller2.movieservice.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody Movie movie, BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        try {
            movieService.save(movie);
        }catch (Exception e){
            return builder.badRequest();
        }
        return builder.success(movie);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        try {
            movieService.delete(id);
        }catch (Exception e){
            return builder.noFound();
        }
        return builder.deleteSuccess();
    }

    @GetMapping
    public List<Movie> findAll(){
        return movieService.findAllMovies();
    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable("id") Long id) {
        return movieService.findMovieById(id);
    }
}
