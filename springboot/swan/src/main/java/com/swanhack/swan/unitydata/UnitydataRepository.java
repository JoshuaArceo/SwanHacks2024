package com.swanhack.swan.unitydata;


import com.swanhack.swan.users.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitydataRepository extends JpaRepository<Unitydata, Long> {
    Unitydata findById(int id);

    List<Unitydata> findAllByUser(User user);

    @Transactional
    void deleteById(int id);
}
