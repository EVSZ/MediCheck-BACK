package medicheck.backend.DataModels;

import medicheck.backend.Prescription.Prescription;
import medicheck.backend.patient.Gender;
import medicheck.backend.patient.HealthInformation;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class PatientDataModel {
    @Id
    @GeneratedValue
    private long id;

    private String name;
    private Integer weight;
    private Integer length;
    private Boolean pregnant;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private HealthInformation healthInfo;

    private int age;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
    private List<PrescriptionDataModel> prescriptions;

    public PatientDataModel() {
    }
}
