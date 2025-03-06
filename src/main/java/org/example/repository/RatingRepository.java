package org.example.repository;

import org.example.entity.Reviewentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Long, Reviewentity> {
}
