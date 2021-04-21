package medicheck.backend.Prescription;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Converters.PrescriptionConverter;
import medicheck.backend.DataModels.PrescriptionDataModel;
import medicheck.backend.Repos.MedicineRepo;
import medicheck.backend.Repos.PrescriptionRepo;
import medicheck.backend.medicine.Medicine;

import java.time.LocalDate;

@Getter @Setter
public class Prescription
{
    private long Id;
    private Medicine medicine;
    private int doses;
    private Integer amount;
    private LocalDate TimePeriod;

    PrescriptionConverter Converter = new PrescriptionConverter();

    public Prescription(Medicine medcine, int doses, long prescriptionId)
    {
        this.medicine = medcine;
        this.doses = doses;
        this.Id = prescriptionId;
    }
    public Prescription(Medicine medcine, int doses)
    {
        this.medicine = medcine;
        this.doses = doses;
    }
    public Prescription(PrescriptionModel prescription)
    {
        this.medicine = prescription.getMedicine();
        this.doses = prescription.getDoses();
        this.Id = prescription.getReceptId();
        this.amount = prescription.getAmount();
        this.TimePeriod = prescription.getTimePeriod();
    }
    public Prescription(PrescriptionDataModel prescriptionDataModel)
    {
        this.medicine = new Medicine(prescriptionDataModel.getMedicine());
        this.doses = prescriptionDataModel.getDoses();
        this.TimePeriod = prescriptionDataModel.getTimePeriod();
        this.Id = prescriptionDataModel.getPrescriptionId();
        this.amount = prescriptionDataModel.getAmount();
    }
    public void Save(PrescriptionRepo repo)
    {
        repo.save(Converter.convertToDataModel(this));
    }
    public void Delete(PrescriptionRepo repo)
    {
        repo.delete(Converter.convertToDataModel(this));
    }
    public void Update(PrescriptionRepo repo)
    {
        repo.findById(this.Id);
        repo.save(Converter.convertToDataModel(this));
    }
}
