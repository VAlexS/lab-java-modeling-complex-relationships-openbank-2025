package com.iron.modelingComplexRelations;

import com.iron.modelingComplexRelations.models.nurses.*;
import com.iron.modelingComplexRelations.repositories.nurses.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ModelingComplexRelationsApplicationTests {

	@Autowired
	ChapterRepository chapterRepository;

	@Autowired
	MemberRepository memberRepository;

	@Test
	@DisplayName("Guardar chapter con miembros")
	@Rollback(false)
	void testSaveAndRetrieveChapterWithMembers(){

		// Crear miembros
		Member president = new Member("Pedro Vidal", Status.ACTIVE, Date.valueOf(LocalDate.of(2025, 4, 25)));
		Member member1 = new Member("Pedro Vidal", Status.ACTIVE, Date.valueOf(LocalDate.of(2025, 3, 12)));
		Member member2 = new Member("Luis Alcoba", Status.ACTIVE,  Date.valueOf(LocalDate.of(2025, 4, 26)));


		// Guardar los miembros
		var memberSaved = memberRepository.saveAll(Arrays.asList(president, member1, member2));
		assertNotNull(memberSaved);

		// Crear un capítulo y asociar los miembros
		Chapter chapter = new Chapter("Healthcare Chapter", "District 1", president, Arrays.asList(member1, member2));
		var chapterSaved = chapterRepository.save(chapter);
		assertNotNull(chapterSaved);

		// Recuperar el capítulo guardado
		Chapter retrievedChapter = chapterRepository.findById(chapter.getId()).orElse(null);

		System.out.println("Chapter = "+retrievedChapter);
	}

}
