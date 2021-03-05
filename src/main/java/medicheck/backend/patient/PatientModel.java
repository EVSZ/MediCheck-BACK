package medicheck.backend.patient;

import java.time.LocalDate;

public class PatientModel {
    private Integer id;
    private String name;
    private Double weight;
    private Double length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;

    public PatientModel(Integer id, String naam, Double weight, Double length, Boolean pregnant, LocalDate birthDate, Gender gender) {
        this.id = id;
        this.name = naam;
        this.weight = weight;
        this.length = length;
        this.pregnant = pregnant;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getLength() {
        return length;
    }

    public Boolean getPregnant() {
        return pregnant;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
