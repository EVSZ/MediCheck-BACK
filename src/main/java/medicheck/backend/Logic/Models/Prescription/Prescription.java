package medicheck.backend.Logic.Models.Prescription;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import medicheck.backend.APIs.RequestModels.PrescriptionModel;
import medicheck.backend.Converters.PrescriptionConverter;
import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import medicheck.backend.DAL.Repos.PrescriptionRepo;
import medicheck.backend.DTO.PrescriptionDTO;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.medicine.MedicineType;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@Getter @Setter
public class Prescription
{
    private long Id;
    private Medicine medicine;
    private Integer doses;
    private Integer amount;
    private LocalDate TimePeriod;
    private long patientID;

//    PrescriptionConverter Converter = new PrescriptionConverter();


    public Prescription(Medicine medicine, int doses, int amount, long id, LocalDate timePeriod){
        this.medicine = medicine;
        this.amount = amount;
        this.doses = doses;
        this.Id = id;
        this.TimePeriod = timePeriod;
    }
    public Prescription(){

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
    public Prescription(PrescriptionDTO prescription){
        this.medicine = new Medicine(prescription.getMedicine());
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
//    public void Save(PrescriptionRepo repo)
//    {
//        repo.save(Converter.convertToDataModel(this));
//    }
//    public void Delete(PrescriptionRepo repo)
//    {
//        repo.delete(Converter.convertToDataModel(this));
//    }
//    public void Update(PrescriptionRepo repo)
//    {
//        repo.findById(this.Id);
//        repo.save(Converter.convertToDataModel(this));
//    }
}
