package com.iron.modelingComplexRelations.repositories.events;

import com.iron.modelingComplexRelations.models.events.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Integer> {
}
