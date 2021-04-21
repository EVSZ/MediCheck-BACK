package medicheck.backend;

import medicheck.backend.Algoritmiek.AdviceGenerator;
import medicheck.backend.Algoritmiek.TestMedicine;
import medicheck.backend.Algoritmiek.TestPatient;
import medicheck.backend.Algoritmiek.TestRule;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
class AlgorithmTest
{
    @Mock
    TestPatient patient;
    TestPatient patient2;
    List<TestMedicine> medication = new ArrayList<>();
    LocalDate birthday;
    LocalDate birthday2;
    boolean expectedResult = false;

    @Before("")
    public void init(){MockitoAnnotations.openMocks(this);}

    @Test
    public void testAlgorithm(){
        medication.add(new TestMedicine("Nitrofurantoine",true,1));
        birthday = LocalDate.of(2020,9,12);
        birthday2 = LocalDate.of(2019,1,1);
        patient = new TestPatient(60,medication,35,birthday);
        patient2 = new TestPatient(60,medication,35,birthday2);
        AdviceGenerator generator = new AdviceGenerator();

        Assertions.assertFalse(generator.GenerateAdvice(patient));
        Assertions.assertTrue(generator.GenerateAdvice(patient2));
    }



}
