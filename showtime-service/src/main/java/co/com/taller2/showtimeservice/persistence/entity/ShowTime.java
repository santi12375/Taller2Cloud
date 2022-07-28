package co.com.taller2.showtimeservice.persistence.entity;


import co.com.taller2.showtimeservice.commons.EntityBase;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@Table(name="showtimes")
@AllArgsConstructor
@NoArgsConstructor
public class ShowTime extends EntityBase {

    //Arreglar validación para poder guardar un showtime y retornar la response deseada.
    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date")
    private Date date;

    /*
    @NotBlank(message = "You must fill this field")
    @Column(name = "movies")
    private String movies[];
    */
}
