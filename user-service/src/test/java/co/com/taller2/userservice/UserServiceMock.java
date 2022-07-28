package co.com.taller2.userservice;

import co.com.taller2.userservice.persistence.entity.User;
import co.com.taller2.userservice.persistence.repository.UserRepository;
import co.com.taller2.userservice.service.UserService;
import co.com.taller2.userservice.service.UserServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserServiceMock {

    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    @BeforeEach
    public void projectServiceTest(){
        MockitoAnnotations.openMocks(this);
        userService = new UserServiceImpl(userRepository);

        User user= User.builder()
                .name("Test Project")
                .lastname("84576")
                .build();
        List<User> users = userService.findAll();
        users.add(user);
        Mockito.when(users).thenReturn(users);
    }

    @Test
    public void when_findProject_return_Project(){
        List<User> users = userService.findAll();;
        Assertions.assertThat(users.size()).isEqualTo(1);
    }

}