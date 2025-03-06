package org.example.repository;

import org.example.entity.Carentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Long, Carentity> {
}
