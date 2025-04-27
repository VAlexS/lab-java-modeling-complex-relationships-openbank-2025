package com.iron.modelingComplexRelations.repositories.events;

import com.iron.modelingComplexRelations.models.events.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}
