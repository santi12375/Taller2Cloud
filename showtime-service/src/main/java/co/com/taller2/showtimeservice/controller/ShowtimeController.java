package co.com.taller2.showtimeservice.controller;

import co.com.taller2.showtimeservice.commons.FormatParser;
import co.com.taller2.showtimeservice.commons.Response;
import co.com.taller2.showtimeservice.commons.ResponseBuild;
import co.com.taller2.showtimeservice.persistence.entity.Showtime;
import co.com.taller2.showtimeservice.services.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody Showtime showtime , BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        try {
            showtimeService.save(showtime);
        }catch (Exception e){
            return builder.badRequest();
        }
        return builder.success(showtime);
    }

    @GetMapping
    public List<Showtime> findAll(){
        return showtimeService.findAll();
    }

    @GetMapping("/{id}")
    public Showtime findById(@PathVariable("id") Long id) {
        return showtimeService.findById(id);
    }

    @PatchMapping("/{id}")
    public Response update(@PathVariable("id") Long id,@Valid @RequestBody Showtime showtime , BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        try {
            Showtime s = showtimeService.findById(id);
            s.setDate(showtime.getDate());
            showtimeService.save(s);
        }catch (Exception e){
            return builder.noFound();
        }
        return builder.success(showtime);
    }
}
