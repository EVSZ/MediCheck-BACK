package medicheck.backend.DataModels;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity @Getter @Setter
public class PrescriptionDataModel {

    @Id
    @GeneratedValue
    private long prescriptionId;
    private LocalDate timePeriod;
    private Integer amount;
    private int doses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_id", insertable = true, updatable = false, referencedColumnName = "id")
    private MedicineDataModel Medicine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", insertable = true, updatable = false, referencedColumnName = "id")
    private PatientDataModel patient;

    public PrescriptionDataModel() { }
}
