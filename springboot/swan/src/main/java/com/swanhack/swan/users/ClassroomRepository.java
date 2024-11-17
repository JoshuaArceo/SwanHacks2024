package com.swanhack.swan.users;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

    Classroom findById(int id);

    @Transactional
    void deleteById(int id);

    List<Classroom> findByMembersContaining(User user);


}
