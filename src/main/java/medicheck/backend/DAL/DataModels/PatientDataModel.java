package medicheck.backend.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.Logic.Models.patient.Gender;
import medicheck.backend.Logic.Models.patient.HealthInformation;
import medicheck.backend.Logic.Models.patient.Patient;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Getter @Setter
@NamedNativeQuery(
        name="PatientDataModel.FindByUsernameAndPassword",
        query = "SELECT * FROM PatientDataModel WHERE username = ? AND password = ?",
        resultClass = PatientDataModel.class
)
@Lazy()
public class PatientDataModel
{
    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String Username;

    @Column(nullable = false)
    private String Password;

    @Column(unique = true, nullable = false)
    private String EmailAddress;

    private String name;

    private LocalDate birthDate;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Embedded
    private HealthInformation healthInfo = new HealthInformation();

    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
    private List<PrescriptionDataModel> prescriptions;

    public PatientDataModel() { }

    public PatientDataModel(PatientDTO patient)
    {
        id = patient.getId();
        name = patient.getName();
        birthDate = patient.getBirthDate();
        gender = patient.getGender();
        healthInfo = new HealthInformation(patient.getHealthInfo());
    }
    public PatientDataModel(AccountDTO patient)
    {
        healthInfo = new HealthInformation();
        Username = patient.getUsername();
        Password = patient.getPassword();
        EmailAddress = patient.getEmail();
    }
}
