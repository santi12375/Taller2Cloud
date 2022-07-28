package co.com.taller2.showtimeservice.services;


import co.com.taller2.showtimeservice.persistence.entity.ShowTime;
import co.com.taller2.showtimeservice.persistence.repository.ShowTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService{

    ShowTimeRepository showTimeRepository;

    @Override
    public void save(ShowTime showTime) {
        showTimeRepository.save(showTime);
    }

    @Override
    public List<ShowTime> findAll() {
       return showTimeRepository.findAll();
    }

    @Override
    public List<ShowTime> findShowTimeById(Long id) {
       return showTimeRepository.findShowTimeById(id);
    }

    /*             Arreglar UPDATE
    @Override
    public void updateShowTimeById(Long id) {
        showTimeRepository.updateShowTimeById(id);
    }
    */

}
