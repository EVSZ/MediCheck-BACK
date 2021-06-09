package medicheck.backend.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.DTO.PrescriptionDTO;
import medicheck.backend.Logic.Models.patient.Gender;
import medicheck.backend.Logic.Models.patient.HealthInformation;
import medicheck.backend.Logic.Models.patient.Patient;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter

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

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient", orphanRemoval = true)
    private List<PrescriptionDataModel> prescriptions;

    public PatientDataModel() { }

    public PatientDataModel(PatientDTO patient)
    {
        id = patient.getId();
        name = patient.getName();
        Password = patient.getPassword();
        Username = patient.getPassword();
        birthDate = patient.getBirthDate();
        gender = patient.getGender();
        EmailAddress = patient.getEmailAddress();
        healthInfo = new HealthInformation(patient.getHealthInfo());
        prescriptions = new ArrayList<>();
        for (PrescriptionDTO prescription : patient.getPrescriptions())
        {
            prescriptions.add(new PrescriptionDataModel(prescription));
        }

    }
    public PatientDataModel(AccountDTO patient)
    {
        Username = patient.getUsername();
        Password = patient.getPassword();
        EmailAddress = patient.getEmail();
    }
}
