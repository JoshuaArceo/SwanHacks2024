package com.swanhack.swan.users;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

        User findByUsername(String username);

        Set<User> findAllByUserType(User.UserType userType);

        Set<User> findAllByClassroom(Classroom classroom);

        @Transactional
        void deleteByUsername(String username);
}
