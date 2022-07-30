package co.com.taller2.bookingservice.clientFeign;

import co.com.taller2.bookingservice.commons.Response;
import co.com.taller2.bookingservice.commons.ResponseBuild;
import co.com.taller2.bookingservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserClientImplHystrixFallback implements MovieClient{

    private final ResponseBuild builder;

    @Override
    public Response findById(Long id) {
        return builder.success(new User());
    }
}
