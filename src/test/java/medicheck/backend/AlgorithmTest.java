package medicheck.backend;

import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.Algoritmiek.TestMedicine;
import medicheck.backend.Algoritmiek.TestPatient;
import medicheck.backend.DAL.MedicineDAL;
import medicheck.backend.DAL.PatientDAL;
import medicheck.backend.DAL.Repos.PatientRepo;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.medicine.MedicineContainer;
import medicheck.backend.Logic.Models.medicine.MedicineType;
import medicheck.backend.Logic.Models.patient.Patient;
import medicheck.backend.Logic.Models.patient.PatientContainer;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Convert;
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
    long ruleid1 = 1;
    long ruleid2 = 2;
    long ruleid3 = 3;
    long patientID = 5;


    @Before("")
    public void init(){MockitoAnnotations.openMocks(this);}

    @Test
    public void testAlgorithmrule1()
    {
        medication.add(new Medicine(medid, true, ruleid1, "Nitrofurantoine", "Hello", MedicineType.Pillen));
        AdviceGenerator generator = new AdviceGenerator(new PatientContainer(new PatientDAL()));
        Assertions.assertTrue(generator.GenerateAdvice(patientID));
    }

    @Test
    public void testAlgorithmrule2()
    {
        medication.add(new Medicine(medid, true, ruleid2, "Norfloxacine", "Hello", MedicineType.Pillen));
        AdviceGenerator generator = new AdviceGenerator(new PatientContainer(new PatientDAL()));
        Assertions.assertTrue(generator.GenerateAdvice(patientID));
    }

    @Test
    public void testAlgorithmrule3()
    {
        medication.add(new Medicine(medid, true, ruleid3, "Cotrimoxazol", "Hello", MedicineType.Pillen));
        AdviceGenerator generator = new AdviceGenerator(new PatientContainer(new PatientDAL()));
        Assertions.assertTrue(generator.GenerateAdvice(patientID));
    }
    @Test
    public void PatientMedstest(){
        PatientContainer container = new PatientContainer(new PatientDAL());
        long patientid = 41;
        long id = 1;
        Patient testpatient = container.GetPatientByID(patientid);

        long test = testpatient.getId();
        Assertions.assertTrue(testpatient.getPrescriptions().GetPrescriptions().get(0).getId() == id) ;
    }

    @Test
    public void GetMedstest(){
        MedicineContainer container = new MedicineContainer(new MedicineDAL());
        List<Medicine> medlist = container.GetAllMedicines();

    }




}
