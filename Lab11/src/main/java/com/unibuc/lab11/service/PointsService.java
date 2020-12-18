package com.unibuc.lab11.service;

import com.unibuc.lab11.domain.Points;
import com.unibuc.lab11.dto.PointsDto;
import com.unibuc.lab11.mapper.PointsMapper;
import com.unibuc.lab11.repository.PointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PointsService {

    @Autowired
    private PointsRepository pointsRepository;

    @Autowired
    private PointsMapper pointsMapper;

    public PointsDto addPointsFor(String username) {
        Points points = Points.builder()
                .username(username)
                .noPoints(100)
                .pointsAddedDate(LocalDateTime.now())
                .build();

        Points savedPoints = pointsRepository.save(points);
        return pointsMapper.mapToDto(savedPoints);
    }

    public PointsDto getPointsFor(String username) {
        Points points = pointsRepository.findByUsername(username);
        return pointsMapper.mapToDto(points);
    }

}
