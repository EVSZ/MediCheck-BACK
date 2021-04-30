package medicheck.backend.Converters;

import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import medicheck.backend.Logic.Models.Prescription.Prescription;

public class PrescriptionConverter
{
    public PrescriptionDataModel convertToDataModel(Prescription prescription)
    {
        MedicineConverter Converter = new MedicineConverter();

        PrescriptionDataModel prescriptionDataModel = new PrescriptionDataModel();
        prescriptionDataModel.setPrescriptionId(prescription.getId());
        prescriptionDataModel.setAmount(prescription.getAmount());
        prescriptionDataModel.setDoses(prescription.getDoses());
        prescriptionDataModel.setTimePeriod(prescription.getTimePeriod());
        prescriptionDataModel.setMedicine(Converter.convertToDataModel(prescription.getMedicine()));

        return prescriptionDataModel;
    }
}
