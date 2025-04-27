package com.iron.modelingComplexRelations.models.nurses;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "chapter")
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String district;


    @OneToOne
    @JoinColumn(name = "president_id")
    private Member president; // Relación uno a uno con el presidente

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Chapter_Member",
            joinColumns = @JoinColumn(name = "chapter_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<Member> members; // Relación uno a muchos con los miembros

    public Chapter() {
    }

    public Chapter(String name, String district, Member president, List<Member> members) {
        this.name = name;
        this.district = district;
        this.president = president;
        this.members = members;
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

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Member getPresident() {
        return president;
    }

    public void setPresident(Member president) {
        this.president = president;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", president=" + president +
                '}';
    }
}
