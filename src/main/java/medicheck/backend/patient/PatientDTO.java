package medicheck.backend.patient;

import java.time.LocalDate;
import medicheck.backend.patient.Patient;

public class PatientDTO {
    private Integer id;
    private String name;
    private Double weight;
    private Double length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String naam) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double gewicht) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double lengte) {
        this.length = length;
    }

    public Boolean getPregnant() {
        return pregnant;
    }

    public void setPregnant(Boolean zwanger) {
        this.pregnant = pregnant;
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


    public PatientDTO(Integer id, String naam,
                      Double gewicht, Double lengte,
                      Boolean zwanger,
                      LocalDate birthDate, Gender gender) {
        this.id = id;
        this.name = naam;
        this.weight = gewicht;
        this.length = lengte;
        this.pregnant = zwanger;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public PatientDTO(String naam, Double gewicht,
                      Double lengte, Boolean zwanger,
                      LocalDate birthDate,
                      Gender gender) {
        this.name = naam;
        this.weight = gewicht;
        this.length = lengte;
        this.pregnant = zwanger;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public PatientDTO(Patient patient) {
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();
        this.pregnant = patient.getPregnant();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }
}
