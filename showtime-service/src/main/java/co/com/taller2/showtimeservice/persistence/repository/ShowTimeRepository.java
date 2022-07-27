package co.com.taller2.showtimeservice.persistence.repository;


import co.com.taller2.showtimeservice.persistence.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime,Long> {

    @Override
    List<ShowTime> findAll();

    List<ShowTime> findShowTimeById(Long id);

    //void updateShowTimeById(Long id);
}
