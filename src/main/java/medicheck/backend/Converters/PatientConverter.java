package medicheck.backend.Converters;

import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import medicheck.backend.Logic.Models.Prescription.Prescription;
import medicheck.backend.Logic.Models.patient.Patient;

import java.util.*;

public class PatientConverter
{
    public PatientDataModel convertToDataModel(Patient patient)
    {
        List<PrescriptionDataModel> prescriptions = new ArrayList<>();
        PrescriptionConverter converter = new PrescriptionConverter();
        PatientDataModel patientModel = new PatientDataModel();

        for (Prescription prescription: patient.getPrescriptions().GetPrescriptions())
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
