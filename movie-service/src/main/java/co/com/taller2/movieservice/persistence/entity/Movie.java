package co.com.taller2.movieservice.persistence.entity;

import co.com.taller2.movieservice.commons.EntityBase;
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
@Table(name="movie")
@AllArgsConstructor
@NoArgsConstructor
public class Movie extends EntityBase {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotBlank(message = "You must fill this field")
    @Column(name = "title")
    private String title;

    @NotBlank(message = "You must fill this field")
    @Column(name = "director")
    private String director;

    @NotBlank(message = "You must fill this field")
    @Size(min = 1,max = 5,message = "The project identifier value must be between 1 and 5")
    @Column(name = "rating")
    private String rating;

}
