package medicheck.backend.Logic.Models.patient;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.APIs.RequestModels.PatientModel;
import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.Logic.Models.Prescription.PrescriptionContainer;

import java.time.LocalDate;
import java.time.Period;

@Getter @Setter
public class Patient
{
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private HealthInformation healthInfo;
    private PrescriptionContainer Prescriptions;
    private int age;

    private PatientConverter converter = new PatientConverter();

    public Patient() { }

    public Patient(Long id, String name,LocalDate birthDate, Gender gender, HealthInformation healthInfo, PrescriptionContainer prescriptions, int age)
    {
        this.id = id;
        this.name = name;
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
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }

    public Patient(PatientModel patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }

    public void Update() { }

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
