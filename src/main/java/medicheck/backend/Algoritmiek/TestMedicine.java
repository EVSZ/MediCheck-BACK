package medicheck.backend.Algoritmiek;

public class TestMedicine
{
    String name;
    boolean hasMedicationRule;
    long medicationRuleNumber;

    public TestMedicine(String name, boolean hasMedicationRule)
    {
        this.name = name;
        this.hasMedicationRule = hasMedicationRule;
    }

    public TestMedicine(String name, boolean hasMedicationRule, long medicationRuleNumber)
    {
        this.name = name;
        this.hasMedicationRule = hasMedicationRule;
        this.medicationRuleNumber = medicationRuleNumber;
    }
}
