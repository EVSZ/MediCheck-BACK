package medicheck.backend.patient;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.PatientDTO;
<<<<<<< Updated upstream
import medicheck.backend.Prescription.Prescription;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
@Builder
@Getter
@Setter
=======
import medicheck.backend.DataModels.PatientDataModel;
import medicheck.backend.Prescription.PrescriptionContainer;
import medicheck.backend.Repos.PatientRepo;

import java.time.LocalDate;
import java.time.Period;

@Getter @Setter
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
=======
    private PatientConverter converter = new PatientConverter();

    public Patient() { }

    public Patient(Integer id, String name, Integer weight, Integer length, Boolean pregnant, LocalDate birthDate, Gender gender, HealthInformation healthInfo, PrescriptionContainer prescriptions, int age) {
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
>>>>>>> Stashed changes

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

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public void Update(Patient patient) {
        this.name = patient.getName();
        this.weight = patient.getWeight();
        this.length = patient.getLength();
    }

    public void Delete()
    {
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
