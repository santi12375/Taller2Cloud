package co.com.taller2.bookingservice.persistence.entity;


import co.com.taller2.bookingservice.commons.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name="booking")
@AllArgsConstructor
@NoArgsConstructor
public class Booking extends EntityBase {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotBlank(message = "You must fill this field")
    @Column(name = "userId")
    private Long userId;

    @NotBlank(message = "You must fill this field")
    @Column(name = "showTimeId")
    private Long showTimeId;


}
