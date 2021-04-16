package medicheck.backend.Algoritmiek;

import java.util.List;

public class MedicationRule
{
    long ruleNumber;
    List<SubRule> subRules;

    public MedicationRule(long ruleNumber, List<SubRule> subRules)
    {
        this.ruleNumber = ruleNumber;
        this.subRules = subRules;
    }

}
