package medicheck.backend.Algoritmiek;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestRule

{
    TestPatient patient;
    List<TestMedicine> medication;
    LocalDate birthday;
    boolean result;
    boolean expectedResult;
    public TestRule()
    {

    }

    public boolean Test()
    {
        medication = new ArrayList<>();
        medication.add(new TestMedicine("Nitrofurantoine",true,1));
        birthday = LocalDate.of(2020,9,12);
        patient = new TestPatient(60,medication,15,birthday);
        expectedResult = false;
        AdviceGenerator generator = new AdviceGenerator();
        result = generator.GenerateAdvice(patient);
        return result == expectedResult;
    }

}

