package medicheck.backend.patient;

import medicheck.backend.Recept.ReceptContainer;
import medicheck.backend.medicine.Medicine;
import medicheck.backend.patient.Gender;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Patient {
    private Integer id;
    private String name;
    private Double weight;
    private Double length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;

    public HealthInformation getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(HealthInformation healthInfo) {
        this.healthInfo = healthInfo;
    }

    private HealthInformation healthInfo;

    public List<Medicine> getMedication() {
        return medication;
    }

    public void setMedication(List<Medicine> medication) {
        this.medication = medication;
    }

    private List<Medicine> medication;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Boolean getPregnant() {
        return pregnant;
    }

    public void setPregnant(Boolean pregnant) {
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

    public Patient(Integer id, String naam,
                   Double weight, Double length,
                   Boolean pregnant, LocalDate birthDate,
                   Gender gender) {
        this.id = id;
        this.name = naam;
        this.weight = weight;
        this.length = length;
        this.pregnant = pregnant;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Patient(PatientDTO Patient) {
        this.name = Patient.getName();
        this.weight = Patient.getWeight();
        this.length = Patient.getLength();
        this.pregnant = Patient.getPregnant();
        this.birthDate = Patient.getBirthDate();
        this.gender = Patient.getGender();
    }

    public Patient(PatientModel Patient) {
        this.name = Patient.getName();
        this.weight = Patient.getWeight();
        this.length = Patient.getLength();
        this.pregnant = Patient.getPregnant();
        this.birthDate = Patient.getBirthDate();
        this.gender = Patient.getGender();
    }
    // !!!for testing!!!
    public Patient(Integer id) {
        this.id = id;
    }

    public Integer CalculateAge() {
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
