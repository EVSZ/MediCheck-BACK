package medicheck.backend.Prescription;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.medicine.Medicine;

@Getter @Setter @Builder
public class Prescription
{
    private Medicine medcine;
    private int doses;
    private long receptId;

    public Prescription(Medicine medcine, int doses, long receptId) {
        this.medcine = medcine;
        this.doses = doses;
        this.receptId = receptId;
    }

    public Prescription(Medicine medcine, int doses) {
        this.medcine = medcine;
        this.doses = doses;
    }
    public Prescription(PrescriptionDTO prescriptionDTO)
    {

    }
}
