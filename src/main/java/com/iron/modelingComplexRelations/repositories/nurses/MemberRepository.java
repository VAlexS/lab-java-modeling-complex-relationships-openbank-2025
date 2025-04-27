package com.iron.modelingComplexRelations.repositories.nurses;

import com.iron.modelingComplexRelations.models.nurses.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
