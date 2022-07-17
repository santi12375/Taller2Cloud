package co.com.taller2.userservice;

import co.com.taller2.userservice.persistence.entity.User;
import co.com.taller2.userservice.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryMockTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void when_findById_return_user(){
        User user = User.builder()
                .name("test")
                .lastname("one").build();
        //Así se le asignaría una reserva
        //.booking(Booking.builder().id(1L).build()).builc();
            userRepository.save(user);
        List<User> users = userRepository.findUsersById(user.getId());
        Assertions.assertThat(users.size()).isEqualTo(1);
    }
}
