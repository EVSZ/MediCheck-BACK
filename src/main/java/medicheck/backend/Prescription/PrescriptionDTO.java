package medicheck.backend.Prescription;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;

@Getter @Setter @Builder
public class PrescriptionDTO
{
    private Medicine medcine;
    private int doses;
<<<<<<< Updated upstream
    private int receptId;
=======
    private int amount;
    private long receptId;
    private LocalDate TimePeriod;
>>>>>>> Stashed changes

    public PrescriptionDTO(Prescription prescription)
    {
        this.amount = prescription.getAmount();
        this.medcine = prescription.getMedicine();
        this.doses = prescription.getDoses();
        this.receptId = prescription.getId();
        this.TimePeriod = prescription.getTimePeriod();
    }

<<<<<<< Updated upstream
    public PrescriptionDTO(Medicine medcine, int doses, int receptId)
=======
    public PrescriptionDTO(Medicine medcine, int doses, int amount, long receptId, LocalDate timePeriod)
>>>>>>> Stashed changes
    {
        this.medcine = medcine;
        this.doses = doses;
        this.amount = amount;
        this.receptId = receptId;
        this.TimePeriod = timePeriod;
    }
}
