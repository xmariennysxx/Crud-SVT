package com.eval.crud.repositories;

import com.eval.crud.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
    Unit findByName(String name);
}
