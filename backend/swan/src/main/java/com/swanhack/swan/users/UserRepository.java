package com.swanhack.swan.users;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Teacher, String> {

        Teacher findByName(java.lang.String name);

        @Transactional
        void deleteByName(String name);
}
