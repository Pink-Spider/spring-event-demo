package io.pinkspider.springeventdemo.user.repo;


import io.pinkspider.springeventdemo.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
