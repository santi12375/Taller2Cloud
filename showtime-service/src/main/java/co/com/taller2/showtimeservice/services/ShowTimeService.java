package co.com.taller2.showtimeservice.services;



import co.com.taller2.showtimeservice.persistence.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {

    void save(ShowTime showTime);

    List<ShowTime> findAll();

    List<ShowTime> findShowTimeById(Long id);

    /*
    void updateShowTimeById(Long id);
    */
}
