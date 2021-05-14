package medicheck.backend;

import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.Algoritmiek.TestMedicine;
import medicheck.backend.Algoritmiek.TestPatient;
import medicheck.backend.DAL.PatientDAL;
import medicheck.backend.DAL.Repos.PatientRepo;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.medicine.MedicineType;
import medicheck.backend.Logic.Models.patient.Patient;
import medicheck.backend.Logic.Models.patient.PatientContainer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
class AlgorithmTest
{
    @Mock
    TestPatient patient;
    TestPatient patient2;
    List<Medicine> medication = new ArrayList<>();
    LocalDate birthday;
    LocalDate birthday2;
    boolean expectedResult = false;
    long medid = 18;
    long ruleid = 1;
    long patientID = 17;

    @Autowired
    PatientRepo patientRepo;

    @Before("")
    public void init(){MockitoAnnotations.openMocks(this);}

    @Test
    public void testAlgorithm(){
        medication.add(new Medicine(medid,true,ruleid,"Nitrofurantoine","Hello", MedicineType.Pillen));
        AdviceGenerator generator = new AdviceGenerator(new PatientContainer(new PatientDAL(patientRepo)));
        Assertions.assertTrue(generator.GenerateAdvice(medication ,patientID));

    }



}
