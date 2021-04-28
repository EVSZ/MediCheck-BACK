package medicheck.backend.Prescription;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;

@Getter @Setter
public class PrescriptionDTO
{
    private Medicine medcine;
    private int doses;
    private int amount;
    private long receptId;
    private LocalDate TimePeriod;


    public PrescriptionDTO(Prescription prescription)
    {
        this.amount = prescription.getAmount();
        this.medcine = prescription.getMedicine();
        this.doses = prescription.getDoses();
        this.receptId = prescription.getId();
        this.TimePeriod = prescription.getTimePeriod();
    }

    public PrescriptionDTO(Medicine medcine, int doses, int amount, long receptId, LocalDate timePeriod)
    {
        this.medcine = medcine;
        this.doses = doses;
        this.amount = amount;
        this.receptId = receptId;
        TimePeriod = timePeriod;
    }
}
