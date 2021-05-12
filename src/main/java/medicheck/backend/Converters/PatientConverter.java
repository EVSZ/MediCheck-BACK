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
        patientModel.getHealthInfo().setLength(patient.getHealthInfo().getLength());
        patientModel.getHealthInfo().setWeight(patient.getHealthInfo().getWeight());
        patientModel.setName(patient.getName());
        patientModel.getHealthInfo().setPregnant(patient.getHealthInfo().getPregnant());
        patientModel.setPrescriptions(prescriptions);

        return patientModel;
    }
}
