package medicheck.backend.Algoritmiek;

import medicheck.backend.Logic.Models.medicine.Medicine;

import java.util.ArrayList;
import java.util.List;

public class RuleSelector {

    public List<Long> CheckForRules(List<Medicine> medication){
        List<Long> selectedRules = new ArrayList<>();

        for (Medicine medicine : medication)
        {
            if (medicine.isHasRule())
            {
                long ruleID = medicine.getRuleID();
                if (!selectedRules.contains(ruleID))
                {
                    selectedRules.add(ruleID);
                }
            }
        }
        return selectedRules;
    }
}

