package medicheck.backend.DataModels;

import medicheck.backend.medicine.Medicine;

import javax.persistence.*;

@Entity
public class PrescriptionDataModel {

    @Id
    @GeneratedValue
    private long prescriptionId;


    //private Medicine medcine;
    private int doses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    private PatientDataModel patient;

    public PrescriptionDataModel() {
    }
}
