package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.Prescription.Prescription;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Builder
@Getter
@Setter
public class Patient
{
    private Integer id;
    private String name;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;
    private HealthInformation healthInfo;
    private List<Prescription> Prescriptions;
    private int age;

    public Patient(Integer id, String name, Integer weight, Integer length, Boolean pregnant, LocalDate birthDate, Gender gender, HealthInformation healthInfo, List<Prescription> prescriptions, int age) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.length = length;
        this.pregnant = pregnant;
        this.birthDate = birthDate;
        this.gender = gender;
        this.healthInfo = healthInfo;
        Prescriptions = prescriptions;
        this.age = age;
    }

    public Patient(PatientDTO patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();
        this.pregnant = patient.getPregnant();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }

    public Patient(PatientModel patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();
        this.pregnant = patient.getPregnant();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }


    public void Update(Patient patient) {
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();
    }

    public void Delete(){

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
