package co.com.taller2.userservice.persistence.repository;

import co.com.taller2.userservice.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findUsersById(long id);

    void deleteUserById(long id);
}
