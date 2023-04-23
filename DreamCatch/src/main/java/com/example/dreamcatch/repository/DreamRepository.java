package com.example.dreamcatch.repository;

import com.example.dreamcatch.model.Dream;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface DreamRepository extends JpaRepository<Dream, Long> {
    @Override
    Dream save(Dream dream);

    List<Dream> findDreamsByDateBetweenAndAndUid(Date date1,Date date2,int uid);
    List<Dream> findDreamsByDateAfterAndUid(Date date, int uid);
}
