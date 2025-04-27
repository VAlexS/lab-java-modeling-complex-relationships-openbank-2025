package com.iron.modelingComplexRelations.models.events;

import jakarta.persistence.*;

@Entity
@Table(name = "speaker")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "presentation_duration")
    private int presentationDuration;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Speaker() {
    }

    public Speaker(String name, int presentationDuration, Event event) {
        this.name = name;
        this.presentationDuration = presentationDuration;
        this.event = event;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPresentationDuration() {
        return presentationDuration;
    }

    public void setPresentationDuration(int presentationDuration) {
        this.presentationDuration = presentationDuration;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", presentationDuration='" + presentationDuration + '\'' +
                ", event=" + event +
                '}';
    }
}
