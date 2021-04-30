package medicheck.backend.Logic.Models.Prescription;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.APIs.RequestModels.PrescriptionModel;
import medicheck.backend.Converters.PrescriptionConverter;
import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import medicheck.backend.DAL.Repos.PrescriptionRepo;
import medicheck.backend.Logic.Models.medicine.Medicine;

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
