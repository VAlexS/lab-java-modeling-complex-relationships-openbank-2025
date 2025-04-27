package com.iron.modelingComplexRelations;

import com.iron.modelingComplexRelations.models.nurses.*;
import com.iron.modelingComplexRelations.models.events.*;
import com.iron.modelingComplexRelations.repositories.events.*;
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

	//ATRIBUTOS PARA EL PAQUETE NURSES
	@Autowired
	ChapterRepository chapterRepository;

	@Autowired
	MemberRepository memberRepository;


	//ATRIBUTOS PARA EL PAQUETE EVENTS

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private GuestRepository guestRepository;

	@Autowired
	private SpeakerRepository speakerRepository;


	//TEST PARA EL PAQUETE NURSES

	@Test
	@DisplayName("Guardar chapter con miembros")
	@Rollback(false)
	void testSaveAndRetrieveChapterWithMembers(){

		// Crear miembros
		Member president = new Member("Pedro Vidal", StatusNurses.ACTIVE, Date.valueOf(LocalDate.of(2025, 4, 25)));
		Member member1 = new Member("Pedro Vidal", StatusNurses.ACTIVE, Date.valueOf(LocalDate.of(2025, 3, 12)));
		Member member2 = new Member("Luis Alcoba", StatusNurses.ACTIVE,  Date.valueOf(LocalDate.of(2025, 4, 26)));


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

	//TEST PARA EL PAQUETE EVENTS

	@Test
	@DisplayName("Guardar un evento")
	void testSaveEvent(){
		var event = new Event(Date.valueOf(LocalDate.of(2025, 4, 25)), 3, "Madrid", "Charla ODS", Type.CONFERENCES);

		var eventSaved = eventRepository.save(event);
		assertNotNull(eventSaved);

		System.out.println("=========================");
		System.out.println("Evento guardado = "+eventSaved);
		System.out.println("============================");
	}

	@Test
	@DisplayName("Guardar 3 invitados para un evento")
	void testSave3GuestOnEvent(){

		var eventToAsign = eventRepository.findById(1);

		assertTrue(eventToAsign.isPresent());

		var guest1 = new Guest("Víctor Sanz", StatusEvent.ATTENDING, eventToAsign.get());
		var guest2 = new Guest("Daniel Molto", StatusEvent.NOT_ATTENDING, eventToAsign.get());
		var guest3 = new Guest("Irene Carvajal", StatusEvent.NO_RESPONSE, eventToAsign.get());

		var guest1Saved = guestRepository.save(guest1);
		var guest2Saved = guestRepository.save(guest2);
		var guest3Saved = guestRepository.save(guest3);

		assertNotNull(guest1Saved);
		assertNotNull(guest2Saved);
		assertNotNull(guest3Saved);

		System.out.println("======================================");
		System.out.println("Los invitados que has metido son: ");
		System.out.println("Invitado 1 = "+guest1Saved);
		System.out.println("Invitado 2 = "+guest2Saved);
		System.out.println("Invitado 3 = "+guest3Saved);


	}

	@Test
	@DisplayName("Guardar 2 presentadores")
	void testSave2Speakers(){

		var eventToAsign = eventRepository.findById(1);

		assertTrue(eventToAsign.isPresent());

		var speaker1 = new Speaker("Marcel", 5, eventToAsign.get());
		var speaker2 = new Speaker("Hector", 3, eventToAsign.get());

		var speaker1Saved = speakerRepository.save(speaker1);
		var speaker2Saved = speakerRepository.save(speaker2);

		assertNotNull(speaker1Saved);
		assertNotNull(speaker2Saved);

		System.out.println("======================================");
		System.out.println("Los presentadores que has metido son: ");
		System.out.println("Presentador 1 = "+speaker1Saved);
		System.out.println("Presentador 2 = "+speaker2Saved);
		System.out.println("======================================");

	}


}
