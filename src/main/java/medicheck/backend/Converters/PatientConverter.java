package medicheck.backend.Converters;

import lombok.Builder;
import lombok.Getter;
import medicheck.backend.DataModels.MedicineDataModel;
import medicheck.backend.DataModels.PatientDataModel;
import medicheck.backend.DataModels.PrescriptionDataModel;
import medicheck.backend.Prescription.Prescription;
import medicheck.backend.medicine.Medicine;
import medicheck.backend.patient.Patient;

import java.util.*;

public class PatientConverter
{
    public PatientDataModel convertToDataModel(Patient patient)
    {
        List<PrescriptionDataModel> prescriptions = new ArrayList<>();
        PrescriptionConverter converter = new PrescriptionConverter();
        PatientDataModel patientModel = new PatientDataModel();

        for (Prescription prescription: patient.getPrescriptions())
        {
            prescriptions.add(converter.convertToDataModel(prescription));
        }

        patientModel.setId(patient.getId());
        patientModel.setAge(patient.getAge());
        patientModel.setBirthDate(patient.getBirthDate());
        patientModel.setLength(patient.getLength());
        patientModel.setWeight(patient.getWeight());
        patientModel.setName(patient.getName());
        patientModel.setPregnant(patient.getPregnant());
        patientModel.setPrescriptions(prescriptions);

        return patientModel;
    }
}
