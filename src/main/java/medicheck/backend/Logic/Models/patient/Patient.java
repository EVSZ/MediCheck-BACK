package medicheck.backend.Logic.Models.patient;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.APIs.RequestModels.AccountInfo;
import medicheck.backend.APIs.RequestModels.PatientModel;
import medicheck.backend.Converters.PatientConverter;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.Interfaces.IAuthentication;
import medicheck.backend.DAL.Interfaces.IPatient;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.Logic.Models.Prescription.PrescriptionContainer;
import org.apache.catalina.User;

import java.time.LocalDate;
import java.time.Period;

@Getter @Setter
public class Patient
{
    private Long id;
    private String Username;
    private String Password;
    private String EmailAddress;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private HealthInformation healthInfo;
    private PrescriptionContainer Prescriptions;
    private int age;

    private PatientConverter converter = new PatientConverter();

    public Patient() { }

    public Patient(PatientDataModel patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
        this.healthInfo = patient.getHealthInfo();
    }
    public Patient(PatientDTO patient)
    {
        this.id = patient.getId();
        this.Username = patient.getUsername();
        this.Password = patient.getPassword();
        this.EmailAddress = patient.getEmailAddress();
        this.name = patient.getName();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
        this.healthInfo = new HealthInformation(patient.getHealthInfo());
    }

    public Patient(PatientModel patient)
    {
        this.id = patient.getId();
        this.name = patient.getName();
        this.birthDate = patient.getBirthDate();
        this.gender = patient.getGender();
    }

    public Patient(AccountInfo info)
    {
        this.Username = info.getUsername();
        this.Password = info.getPassword();
        this.EmailAddress = info.getEmail();
    }

    public void RegisterPatient(IAuthentication authentication)
    {
        authentication.RegisterPatient(new AccountDTO(this));
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
