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
        patient.setEmailAddress("Boterham@boter.ham");
        patient.setName("Boter");
        patient.setId(patID);
        healthInformationDTO.setClcr(5);
        healthInformationDTO.setLength(170);
        healthInformationDTO.setPregnant(true);
        healthInformationDTO.setLastclcr(date);
        healthInformationDTO.setWeight(90);
        patient.setHealthInfo(healthInformationDTO);
        patient.setGender(Gender.Female);
        patient.setBirthDate(date);
        PrescriptionDTO pre = new PrescriptionDTO(new Medicine(medID,true,medID,"NierFunctie","nitrofurantoine", MedicineType.Siroop),9000,17,medID,date,patID);
        PrescriptionDTO pre2 = new PrescriptionDTO(new Medicine(medID,true,medID,"Testfunctie","nitrofurantoine", MedicineType.Siroop),45,4,medID,date,patID);
        prescriptions.add(pre);
        prescriptions.add(pre2);

        patient.setPrescriptions(prescriptions);

        patientDAL.UpdatePatient(patient);
    }

}
