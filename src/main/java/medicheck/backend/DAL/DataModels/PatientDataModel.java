package medicheck.backend.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Logic.Models.patient.Gender;
import medicheck.backend.Logic.Models.patient.HealthInformation;
import medicheck.backend.Logic.Models.patient.Patient;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity @Getter @Setter
public class PatientDataModel
{

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;
    private LocalDate birthDate;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Embedded
    private HealthInformation healthInfo;

    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
    private List<PrescriptionDataModel> prescriptions;

    public PatientDataModel() { }

    public PatientDataModel(Patient patient)
    {

    }
}
