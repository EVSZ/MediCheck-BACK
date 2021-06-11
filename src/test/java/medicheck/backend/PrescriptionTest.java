package medicheck.backend;

import medicheck.backend.DAL.PatientDAL;
import medicheck.backend.DTO.HealthInformationDTO;
import medicheck.backend.DTO.PatientDTO;
import medicheck.backend.DTO.PrescriptionDTO;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.medicine.MedicineType;
import medicheck.backend.Logic.Models.patient.Gender;
import medicheck.backend.Logic.Models.patient.HealthInformation;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionTest
{

    PatientDAL patientDAL = new PatientDAL();
    PatientDTO patient = new PatientDTO();
    HealthInformationDTO healthInformationDTO = new HealthInformationDTO();

    long medID = 1;
    long patID = 41;
    LocalDate date = LocalDate.of(1,1,1);
    List<PrescriptionDTO> prescriptions = new ArrayList<>();


    @Test
    public void test(){
        patient.setUsername("Broodje");
        patient.setPassword("Wattefuak");
        patient.setEmailAddress("Boter@boter.ham");
        patient.setName("Boter");
        patient.setId(patID);
        healthInformationDTO.setClcr(40);
        healthInformationDTO.setLength(180);
        healthInformationDTO.setPregnant(false);
        healthInformationDTO.setLastclcr(date);
        healthInformationDTO.setWeight(90);
        patient.setHealthInfo(healthInformationDTO);
        patient.setGender(Gender.Male);
        patient.setBirthDate(date);
        PrescriptionDTO pre = new PrescriptionDTO(new Medicine(true,medID,MedicineType.Pillen,"nitrofurantoine",medID, "Nierfunctie"),1,2,medID,date,patID);
        PrescriptionDTO pre2 = new PrescriptionDTO(new Medicine(true,medID,MedicineType.Pillen,"nitrofurantoine",medID, "Nierfunctie"),2,2,medID,date,patID);
        prescriptions.add(pre);
        prescriptions.add(pre2);

        patient.setPrescriptions(prescriptions);

        patientDAL.UpdatePatient(patient);
    }

}
