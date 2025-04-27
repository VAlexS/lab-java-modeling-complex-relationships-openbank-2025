package com.iron.modelingComplexRelations.repositories.events;

import com.iron.modelingComplexRelations.models.events.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}
