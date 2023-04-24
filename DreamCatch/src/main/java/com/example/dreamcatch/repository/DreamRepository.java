package com.example.dreamcatch.repository;

import com.example.dreamcatch.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DreamRepository extends JpaRepository<Dream, Long> {
    @Override
    Dream save(Dream dream);

    List<Dream> findDreamsByDateAfterAndUid(Date date, int uid);

}
