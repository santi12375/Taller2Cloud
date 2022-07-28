package co.com.taller2.movieservice.persistence.entity;

import co.com.taller2.movieservice.commons.EntityBase;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "movie")
@Getter
@Setter
@Builder
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

    @Min(value = 1,message = "The rating must be between 1 and 5")
    @Max(value = 5,message = "The rating must be between 1 and 5")
    @NotNull(message = "You must fill this field")
    @Column(name = "rating")
    private int rating;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
