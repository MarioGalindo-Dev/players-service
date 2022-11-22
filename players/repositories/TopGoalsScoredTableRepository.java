package com.soccer.players.repositories;

import com.soccer.players.entities.TopGoalScorer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopGoalsScoredTableRepository extends JpaRepository<TopGoalScorer, Integer> {
}