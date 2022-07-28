package co.com.taller2.bookingservice.services;

import co.com.taller2.bookingservice.persistence.entity.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);

    void delete(long id);

    List<Booking> findAll();

    Booking findBookingByUserId(Long userId);

    Booking findBookingById(Long id);


}
