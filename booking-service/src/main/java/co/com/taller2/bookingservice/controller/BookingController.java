package co.com.taller2.bookingservice.controller;


import co.com.taller2.bookingservice.commons.FormatParser;
import co.com.taller2.bookingservice.commons.Response;
import co.com.taller2.bookingservice.commons.ResponseBuild;
import co.com.taller2.bookingservice.persistence.entity.Booking;
import co.com.taller2.bookingservice.services.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody Booking booking , BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        try {
            bookingService.save(booking);
        }catch (Exception e){
            return builder.badRequest();
        }
        return builder.success(booking);
    }

    @GetMapping
    public Response findAll(){
        return builder.getSuccess(bookingService.findAll());
    }

    @GetMapping("/{id}")
    public List<Booking> findBookingById(@PathVariable("id") Long id){
        return this.bookingService.findBookingById(id);
    }

    @GetMapping("/{userId}")
    public List<Booking> findBookingByUserId(@PathVariable("userId") Long userId){
        return this.bookingService.findBookingByUserId(userId);
    }

    @DeleteMapping("/{id}")
    public Response deleteBookingById(@PathVariable("id") Long id){

        if(bookingService.findBookingById(id).isEmpty()){
            return builder.noFound();
        }

        try {
            this.bookingService.delete(id);
            return builder.deleteSuccess();
        }catch (Exception e){
            return builder.noFound();
        }
    }
}
