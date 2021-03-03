package medicheck.backend.patiënt;

import medicheck.backend.Recept.ReceptContainer;

import java.time.LocalDate;

public class Patiënt {
    private Integer id;
    private String naam;
    private Double gewicht;
    private Double lengte;
    private Boolean zwanger;
    private LocalDate birthDate;
    private Gender gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public Double getLengte() {
        return lengte;
    }

    public void setLengte(Double lengte) {
        this.lengte = lengte;
    }

    public Boolean getZwanger() {
        return zwanger;
    }

    public void setZwanger(Boolean zwanger) {
        this.zwanger = zwanger;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Patiënt(Integer id, String naam,
                   Double gewicht, Double lengte,
                   Boolean zwanger, LocalDate birthDate,
                   Gender gender) {
        this.id = id;
        this.naam = naam;
        this.gewicht = gewicht;
        this.lengte = lengte;
        this.zwanger = zwanger;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Patiënt(String naam, Double gewicht,
                   Double lengte, Boolean zwanger,
                   LocalDate birthDate, Gender gender) {
        this.naam = naam;
        this.gewicht = gewicht;
        this.lengte = lengte;
        this.zwanger = zwanger;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Patiënt(PatiëntDTO patiënt) {
        this.naam = patiënt.getNaam();
        this.gewicht = patiënt.getGewicht();
        this.lengte = patiënt.getLengte();
        this.zwanger = patiënt.getZwanger();
        this.birthDate = patiënt.getBirthDate();
        this.gender = patiënt.getGender();
    }

    public Patiënt(PatiëntModel patiënt) {
        this.naam = patiënt.getNaam();
        this.gewicht = patiënt.getGewicht();
        this.lengte = patiënt.getLengte();
        this.zwanger = patiënt.getZwanger();
        this.birthDate = patiënt.getBirthDate();
        this.gender = patiënt.getGender();
    }
    // !!!for testing!!!
    public Patiënt(Integer id) {
        this.id = id;
    }
}
