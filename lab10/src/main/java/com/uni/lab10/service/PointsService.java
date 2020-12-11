package com.uni.lab10.service;

import com.uni.lab10.domain.Points;
import com.uni.lab10.dto.PointsDto;
import com.uni.lab10.mapper.PointsMapper;
import com.uni.lab10.repository.PointsRepository;
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
