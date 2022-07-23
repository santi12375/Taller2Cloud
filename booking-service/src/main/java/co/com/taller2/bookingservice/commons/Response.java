package co.com.taller2.bookingservice.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String code;
    private Object data;
}
