package medicheck.backend.Prescription;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DataModels.PrescriptionDataModel;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;

@Getter @Setter @Builder
public class Prescription
{
    private long Id;
    private Medicine medicine;
    private int doses;
<<<<<<< Updated upstream
    private int receptId;

    public Prescription(Medicine medcine, int doses) {
        this.medcine = medcine;
=======
    private Integer amount;
    private LocalDate TimePeriod;

    public Prescription(Medicine medcine, int doses, long prescriptionId)
    {
        this.medicine = medcine;
        this.doses = doses;
        this.Id = prescriptionId;
    }
    public Prescription(Medicine medcine, int doses)
    {
        this.medicine = medcine;
>>>>>>> Stashed changes
        this.doses = doses;
    }
    public Prescription(PrescriptionDTO prescriptionDTO)
    {
        this.medicine = prescriptionDTO.getMedcine();
        this.doses = prescriptionDTO.getDoses();
        this.Id = prescriptionDTO.getReceptId();
        this.amount = prescriptionDTO.getAmount();
        this.TimePeriod = prescriptionDTO.getTimePeriod();
    }
    public Prescription(PrescriptionDataModel prescriptionDataModel)
    {
        this.medicine = new Medicine(prescriptionDataModel.getMedicine());
        this.doses = prescriptionDataModel.getDoses();
        this.TimePeriod = prescriptionDataModel.getTimePeriod();
        this.Id = prescriptionDataModel.getPrescriptionId();
        this.amount = prescriptionDataModel.getAmount();
    }
}
