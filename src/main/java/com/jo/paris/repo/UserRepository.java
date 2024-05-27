package com.jo.paris.repo;

import com.jo.paris.entity.User;
import com.jo.paris.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    User findByRole(UserRole role);

    List<User> findAllByRole(UserRole role);


}
