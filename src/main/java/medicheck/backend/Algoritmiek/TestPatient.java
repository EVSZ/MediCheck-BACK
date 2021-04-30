package medicheck.backend.Algoritmiek;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class TestPatient
{
    public int age;
    public List<TestMedicine> medication;
    public int clcr;
    public LocalDate lastClcr;

    public TestPatient(int age, List<TestMedicine> medication, int clcr, LocalDate lastClcr)
    {
        this.age = age;
        this.medication = medication;
        this.clcr = clcr;
        this.lastClcr = lastClcr;
    }
}
