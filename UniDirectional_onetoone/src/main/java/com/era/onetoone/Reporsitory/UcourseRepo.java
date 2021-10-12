package com.era.onetoone.Reporsitory;

import com.era.onetoone.models.Ucourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UcourseRepo extends JpaRepository<Ucourse,Integer> {
}
