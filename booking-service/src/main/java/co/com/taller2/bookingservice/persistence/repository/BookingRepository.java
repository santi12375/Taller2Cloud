package co.com.taller2.bookingservice.persistence.repository;


import co.com.taller2.bookingservice.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Override
    List<Booking> findAll();

    Booking findBookingById(long id);

    Booking findBookingByUserId(long id);

    void deleteBookingById(long id);
}
