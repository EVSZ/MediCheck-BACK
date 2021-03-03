package medicheck.backend.patiënt;

import medicheck.backend.Recept.ReceptContainer;

import java.time.LocalDate;

public class PatiëntModel {
    private Integer id;
    private String naam;
    private Double gewicht;
    private Double lengte;
    private Boolean zwanger;
    private LocalDate birthDate;
    private Gender gender;


    public PatiëntModel(Integer id, String naam, Double gewicht, Double lengte, Boolean zwanger, LocalDate birthDate, Gender gender) {
        this.id = id;
        this.naam = naam;
        this.gewicht = gewicht;
        this.lengte = lengte;
        this.zwanger = zwanger;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public Double getLengte() {
        return lengte;
    }

    public Boolean getZwanger() {
        return zwanger;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
