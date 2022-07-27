package co.com.taller2.showtimeservice.controller;


import co.com.taller2.showtimeservice.commons.FormatParser;
import co.com.taller2.showtimeservice.commons.Response;
import co.com.taller2.showtimeservice.commons.ResponseBuild;
import co.com.taller2.showtimeservice.persistence.entity.ShowTime;
import co.com.taller2.showtimeservice.services.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowTimesController {

    private final ShowTimeService showTimeService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody ShowTime showtime , BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        try {
            showTimeService.save(showtime);
        }catch (Exception e){
            return builder.badRequest();
        }
        return builder.success(showtime);
    }

    @GetMapping
    public Response findAll(){
        return builder.getSuccess(showTimeService.findAll());
    }

    @GetMapping("/{id}")
    public List<ShowTime> findMovieById(@PathVariable("id") Long id){
        return this.showTimeService.findShowTimeById(id);
    }

    @PatchMapping("/{id}")
    public Response deleteMovieById(@PathVariable("id") Long id){

        if(showTimeService.findShowTimeById(id).isEmpty()){
            return builder.noFound();
        } //else donde si lo encuentra se fije en bookings aver si no hay reservas asociadas a el id de dicha pelicula

        try {
            //--------------------------Arreglar para que permita modificacion--------------------
            this.showTimeService.findShowTimeById(id);
            return builder.deleteSuccess();
        }catch (Exception e){
            return builder.noFound();
        }
    }
}
