package co.com.taller2.bookingservice.clientFeign;

import co.com.taller2.bookingservice.commons.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "movie-service")
public interface MovieClient {

    @GetMapping("/taller2/api/v1/movies/{id}")
    Response findById(@PathVariable("id") Long id);
}
