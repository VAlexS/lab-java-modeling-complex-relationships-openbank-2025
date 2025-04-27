package com.iron.modelingComplexRelations.repositories.nurses;

import com.iron.modelingComplexRelations.models.nurses.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Integer> {
}
