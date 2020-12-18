package com.unibuc.lab11.repository;

import com.unibuc.lab11.domain.Points;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointsRepository extends JpaRepository<Points, Long> {

    Points findByUsername(String username);
}
