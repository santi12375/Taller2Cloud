package co.com.taller2.bookingservice.services;



import co.com.taller2.bookingservice.persistence.entity.Booking;

import java.util.List;

public interface BookingService {

    void save(Booking booking);

    List<Booking> findAll();

    List<Booking> findBookingByUserId(Long userId);

    List<Booking> findBookingById(Long id);

    void delete(Long id);
}
