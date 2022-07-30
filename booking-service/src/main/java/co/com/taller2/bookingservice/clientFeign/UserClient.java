package co.com.taller2.bookingservice.clientFeign;

import co.com.taller2.bookingservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service")
public interface UserClient {

    @GetMapping("/taller2/api/v1/users/{id}")
    User findById(@PathVariable("id") Long id);

}
