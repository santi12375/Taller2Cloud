package co.com.taller2.bookingservice.persistence.entity;

import co.com.taller2.bookingservice.commons.EntityBase;
import co.com.taller2.bookingservice.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@Builder
@Entity
@Table(name="booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends EntityBase {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotNull(message = "You must fill this field")
    @Column(name = "userId")
    private Long userId;

    @NotNull(message = "You must fill this field")
    @Column(name = "showTimeId")
    private Long showTimeId;

    @Transient
    private User user;

    //Lista de Movies (feign)

    /*

    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    private Showtime showtime;

    @JsonManagedReference
    @OneToMany(mappedBy = "booking",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Movie> movies;

     */
}
