package co.com.taller2.showtimeservice.persistence.entity;


import co.com.taller2.showtimeservice.commons.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name="showtimes")
@AllArgsConstructor
@NoArgsConstructor
public class ShowTime extends EntityBase {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotNull(message = "You must fill this field")
    @Column(name = "date")
    private String date;

    @NotBlank(message = "You must fill this field")
    @Column(name = "movies")
    private String movies[];

}
