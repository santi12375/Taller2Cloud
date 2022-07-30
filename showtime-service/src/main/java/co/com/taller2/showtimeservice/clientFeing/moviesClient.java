package co.com.taller2.showtimeservice.clientFeing;



import co.com.taller2.showtimeservice.commons.Response;
import co.com.taller2.showtimeservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "movie-service")
public interface moviesClient {
    @GetMapping("/taller2/api/v1/movies/{id}")
    Movie findById(@PathVariable("id") Long id);
}
