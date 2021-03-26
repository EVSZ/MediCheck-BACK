package medicheck.backend.Converters;

import medicheck.backend.DataModels.PatientDataModel;
import medicheck.backend.Prescription.Prescription;
import medicheck.backend.patient.Patient;

public class PatientConverter {

    public PatientConverter() {
    }

    public PatientDataModel convertToDataModel(Patient patient){
        PatientDataModel patientDataModel = new PatientDataModel();
        patientDataModel.setId(patient.getId());
        patientDataModel.setName(patient.getName());
        patientDataModel.setWeight(patient.getWeight());
        patientDataModel.setLength(patient.getLength());
        patientDataModel.setPregnant(patient.getPregnant());
        patientDataModel.setBirthDate(patient.getBirthDate());
        patientDataModel.setGender(patient.getGender());
        patientDataModel.setHealthInfo(patient.getHealthInfo());
        patientDataModel.setAge(patient.getAge());

        return patientDataModel;
    }
}
