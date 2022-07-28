package co.com.taller2.showtimeservice.persistence.repository;

import co.com.taller2.showtimeservice.persistence.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
    @Override
    List<Showtime> findAll();

    Showtime findShowtimeById(Long id);
}
