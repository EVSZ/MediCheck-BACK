package medicheck.backend.Algoritmiek;

import java.util.ArrayList;
import java.util.List;

public class RuleSelector {

    public List<Long> CheckForRules(List<TestMedicine> medication){
        List<Long> selectedRules = new ArrayList<>();
        for (TestMedicine medicine : medication)
        {
            if (medicine.hasMedicationRule)
            {
                selectedRules.add(medicine.medicationRuleNumber);
            }
        }
        return selectedRules;
    }
}

