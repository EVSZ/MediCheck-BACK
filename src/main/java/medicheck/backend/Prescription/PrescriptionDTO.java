package medicheck.backend.Prescription;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.medicine.Medicine;

@Getter @Setter @Builder
public class PrescriptionDTO
{
    private Medicine medcine;
    private int doses;
    private int receptId;

    public PrescriptionDTO(Prescription prescription)
    {
        this.medcine = prescription.getMedcine();
        this.doses = prescription.getDoses();
        this.receptId = prescription.getReceptId();
    }

    public PrescriptionDTO(Medicine medcine, int doses, int receptId)
    {
        this.medcine = medcine;
        this.receptId = receptId;
        this.doses = doses;
    }
}
