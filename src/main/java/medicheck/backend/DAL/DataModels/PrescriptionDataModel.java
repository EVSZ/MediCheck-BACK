package medicheck.backend.DAL.DataModels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter @Setter
public class PrescriptionDataModel {

    @Id
    @GeneratedValue
    private long prescriptionId;

    @Column(nullable = true)
    private LocalDate timePeriod;

    @Column(nullable = true)
    private Integer amount;

    @Column(nullable = true)
    private Integer doses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", insertable = true, updatable = false, referencedColumnName = "id")
    private MedicineDataModel Medicine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = true, updatable = false, referencedColumnName = "id")
    private PatientDataModel patient;

    public PrescriptionDataModel() { }
}
