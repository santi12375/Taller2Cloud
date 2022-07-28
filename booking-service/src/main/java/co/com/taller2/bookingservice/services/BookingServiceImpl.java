package co.com.taller2.bookingservice.services;


import co.com.taller2.bookingservice.persistence.entity.Booking;
import co.com.taller2.bookingservice.persistence.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService{

    private final BookingRepository bookingRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
       return bookingRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findBookingByUserId(Long userId) {
        return bookingRepository.findBookingByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Booking findBookingById(Long id) {
        return bookingRepository.findBookingById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(long id) {
    bookingRepository.deleteBookingById(id);
    }
}
