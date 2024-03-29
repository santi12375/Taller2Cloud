package co.com.taller2.showtimeservice.persistence.entity;

import co.com.taller2.showtimeservice.commons.EntityBase;
import co.com.taller2.showtimeservice.model.Movie;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="showtime")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Showtime extends EntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false,nullable = false,unique = true)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date")
    private Date date;


    @Transient
    private Movie movie;

    /*
    @JsonManagedReference
    @OneToMany(mappedBy = "showtime",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private List<Movie> movies;

     */

    @Override
    public String toString() {
        return "Showtime{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
