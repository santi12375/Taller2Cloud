package co.com.taller2.bookingservice.services;


import co.com.taller2.bookingservice.persistence.entity.Booking;
import co.com.taller2.bookingservice.persistence.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    BookingRepository bookingRepository;


    @Override
    public void save(Booking booking) {

    }

    @Override
    public List<Booking> findAll() {
        return null;
    }

    @Override
    public List<Booking> findBookingByUserId(Long userId) {
        return null;
    }

    @Override
    public List<Booking> findBookingById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
