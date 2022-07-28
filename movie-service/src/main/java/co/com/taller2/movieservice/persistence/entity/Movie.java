package co.com.taller2.movieservice.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "movie")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

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

    @Min(1)
    @Max(5)
    @NotBlank(message = "You must fill this field")
    @Column(name = "rating")
    private String rating;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

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
