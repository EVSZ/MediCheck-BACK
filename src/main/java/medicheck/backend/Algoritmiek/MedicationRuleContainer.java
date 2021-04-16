package medicheck.backend.Algoritmiek;

import java.util.ArrayList;
import java.util.List;

public class MedicationRuleContainer
{
    public MedicationRule GetMedicationRule(long rulenumber){
        return new MedicationRule(rulenumber, new ArrayList<SubRule>());
    }
}
