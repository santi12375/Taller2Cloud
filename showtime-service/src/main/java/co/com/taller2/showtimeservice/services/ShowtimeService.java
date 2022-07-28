package co.com.taller2.showtimeservice.services;

import co.com.taller2.showtimeservice.persistence.entity.Showtime;

import java.util.List;

public interface ShowtimeService {

    void save(Showtime showtime);

    List<Showtime> findAll();

    Showtime findById(Long id);

}
