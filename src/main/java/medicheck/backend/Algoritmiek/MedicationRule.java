package medicheck.backend.Algoritmiek;

import lombok.Getter;

import java.util.List;

public class MedicationRule
{
    long ruleNumber;
    @Getter
    List<SubRule> subRules;

    public MedicationRule(long ruleNumber, List<SubRule> subRules)
    {
        this.ruleNumber = ruleNumber;
        this.subRules = subRules;
    }

}
