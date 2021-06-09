package medicheck.backend.DTO;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import medicheck.backend.Logic.Models.Prescription.Prescription;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.patient.Patient;

import java.time.LocalDate;

@Getter @Setter
public class PrescriptionDTO
{
    private MedicineDTO medicine;
    private int doses;
    private int amount;
    private long receptId;
    private LocalDate TimePeriod;
    long patientID;



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

    public PrescriptionDTO(Medicine medicine, int doses, int amount, long receptId, LocalDate timePeriod, long patientID)
    {
        this.medicine = new MedicineDTO(medicine);
        this.doses = doses;
        this.amount = amount;
        this.receptId = receptId;
        TimePeriod = timePeriod;
        this.patientID = patientID;
    }
}
