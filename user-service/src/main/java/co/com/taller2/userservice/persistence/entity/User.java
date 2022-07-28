package co.com.taller2.userservice.persistence.entity;

import co.com.taller2.userservice.commons.EntityBase;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends EntityBase {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotBlank(message = "You must fill this field")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "You must fill this field")
    @Column(name = "lastname")
    private String lastname;

    /*
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;
       */

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
