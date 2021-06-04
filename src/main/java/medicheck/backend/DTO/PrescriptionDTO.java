package medicheck.backend.DTO;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import medicheck.backend.Logic.Models.Prescription.Prescription;
import medicheck.backend.Logic.Models.medicine.Medicine;

import java.time.LocalDate;

@Getter @Setter
public class PrescriptionDTO
{
    private MedicineDTO medicine;
    private int doses;
    private int amount;
    private long receptId;
    private LocalDate TimePeriod;


    public PrescriptionDTO(Prescription prescription)
    {
        this.amount = prescription.getAmount();
        this.doses = prescription.getDoses();
        this.receptId = prescription.getId();
        this.TimePeriod = prescription.getTimePeriod();
    }
    public PrescriptionDTO(PrescriptionDataModel prescription){
        this.receptId = prescription.getPrescriptionId();
        this.amount = prescription.getAmount();
        this.medicine = new MedicineDTO(prescription.getMedicine());
        this.doses = prescription.getDoses();
        this.TimePeriod = prescription.getTimePeriod();
    }

    public PrescriptionDTO(Medicine medicine, int doses, int amount, long receptId, LocalDate timePeriod)
    {
        this.doses = doses;
        this.amount = amount;
        this.receptId = receptId;
        TimePeriod = timePeriod;
    }
}
