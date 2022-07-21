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
    public Response save(@Valid @RequestBody Movie movie , BindingResult result){
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

    @GetMapping
    public Response findAll(){
        return builder.getSuccess(movieService.findAll());
    }

    @GetMapping("/{id}")
    public List<Movie> findMovieById(@PathVariable("id") Long id){
        return this.movieService.findMovieById(id);
    }

    @DeleteMapping("/{id}")
    public Response deleteMovieById(@PathVariable("id") Long id){

        if(movieService.findMovieById(id).isEmpty()){
            return builder.noFound();
        } //else donde si lo encuentra se fije en bookings aver si no hay reservas asociadas a el id de dicha pelicula

        try {
            this.movieService.delete(id);
            return builder.deleteSuccess();
        }catch (Exception e){
            return builder.noFound();
        }
    }
}
