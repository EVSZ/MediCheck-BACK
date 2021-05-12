package medicheck.backend.DTO;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.Logic.Models.patient.Gender;
import medicheck.backend.Logic.Models.patient.HealthInformation;
import medicheck.backend.Logic.Models.patient.Patient;

@Getter
@Setter
public class PatientDTO
{
    private Long id;
    private String Username;
    private String Password;
    private String EmailAddress;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private HealthInformation healthInfo;

    public PatientDTO(Long id, String naam, LocalDate birthDate, Gender gender, HealthInformation HealthInfo)
    {
        this.id = id;
        this.name = naam;
        this.birthDate = birthDate;
        this.gender = gender;
        this.healthInfo = HealthInfo;
    }


    public PatientDTO(Patient patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
        this.healthInfo = patient.getHealthInfo();
    }

    public PatientDTO(PatientDataModel patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
        this.healthInfo = patient.getHealthInfo();
    }
}
