package medicheck.backend.Algoritmiek;

import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
public class TestPatient
{
    @Getter
    public int age;
    public List<TestMedicine> medication;
    public int clcr;
    public LocalDate lastClcr;
}
