package medicheck.backend.Converters;

import medicheck.backend.APIs.RequestModels.PatientModel;
import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.DataModels.PrescriptionDataModel;
import medicheck.backend.Logic.Models.Prescription.Prescription;
import medicheck.backend.Logic.Models.patient.Patient;

import java.util.*;

public class PatientConverter
{
    public PatientModel convertToRequestModel(Patient patient)
    {
        PatientModel patientModel = new PatientModel();
        patientModel.setUserid(patient.getId());
        patientModel.setBirthDate(patient.getBirthDate());
        patientModel.setLength(patient.getHealthInfo().getLength());
        patientModel.setWeight(patient.getHealthInfo().getWeight());
        patientModel.setName(patient.getName());
        patientModel.setPregnant(patient.getHealthInfo().getPregnant());
        patientModel.setHealthInformation(patient.getHealthInfo());
        for (Prescription pres:patient.getPrescriptions().GetPrescriptions())
        {
            patientModel.setUserPrescriptions(patient.getPrescriptions().GetPrescriptions());
        }


        return patientModel;
    }


}
