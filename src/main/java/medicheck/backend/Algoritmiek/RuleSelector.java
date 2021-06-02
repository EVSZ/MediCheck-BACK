package medicheck.backend.Algoritmiek;

import medicheck.backend.Logic.Models.Prescription.Prescription;
import medicheck.backend.Logic.Models.medicine.Medicine;

import java.util.ArrayList;
import java.util.List;

public class RuleSelector {

    public List<Long> CheckForRules(List<Prescription> prescriptions){
        List<Long> selectedRules = new ArrayList<>();

        for (Prescription prescription : prescriptions)
        {
            Medicine medicine = prescription.getMedicine();
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

