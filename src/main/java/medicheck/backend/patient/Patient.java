package medicheck.backend.patient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.DataModels.PatientDataModel;
import medicheck.backend.Prescription.Prescription;
import medicheck.backend.Prescription.PrescriptionContainer;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Getter @Setter @Builder
public class Patient
{
    private Long id;
    private String name;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;
    private LocalDate birthDate;
    private Gender gender;
    private HealthInformation healthInfo;
    private PrescriptionContainer Prescriptions;
    private int age;

    private PatientConverter converter = new PatientConverter();

    public Patient() { }

    public Patient(Long id, String name, Integer weight, Integer length, Boolean pregnant, LocalDate birthDate, Gender gender, HealthInformation healthInfo, PrescriptionContainer prescriptions, int age)
    {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.length = length;
        this.pregnant = pregnant;
        this.birthDate = birthDate;
        this.gender = gender;
        this.healthInfo = healthInfo;
        this.Prescriptions = prescriptions;
        this.age = age;
    }

    public Patient(PatientDataModel patient)
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

    public void Delete() { }

    public Integer CalculateAge() {
        LocalDate currentDate = LocalDate.now();
        if (birthDate != null) {
            return Period.between(birthDate, currentDate).getYears();
        } else {
            return 0;
        }
    }
}
