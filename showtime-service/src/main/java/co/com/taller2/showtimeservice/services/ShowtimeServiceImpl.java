package co.com.taller2.showtimeservice.services;

import co.com.taller2.showtimeservice.clientFeing.moviesClient;
import co.com.taller2.showtimeservice.model.Movie;
import co.com.taller2.showtimeservice.persistence.entity.Showtime;
import co.com.taller2.showtimeservice.persistence.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowtimeServiceImpl implements ShowtimeService{

    private final ShowtimeRepository showtimeRepository;

    @Autowired
    private final moviesClient movieClient;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Showtime showtime) {
        Movie movie = movieClient.findById(showtime.getMovie().getId());
        showtime.setMovie(movie);
        showtimeRepository.save(showtime);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Showtime> findAll() {


        return showtimeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Showtime findById(Long id) {
        Showtime showtime = showtimeRepository.findShowtimeById(id);
        if(null != showtime){
            Movie movie = movieClient.findById(showtime.getMovie().getId());
            showtime.setMovie(movie);
        }
        return showtime;
    }



}
