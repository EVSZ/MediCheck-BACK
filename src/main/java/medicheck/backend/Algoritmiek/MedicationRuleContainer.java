package medicheck.backend.Algoritmiek;

import java.util.ArrayList;
import java.util.List;

public class MedicationRuleContainer
{
    public MedicationRule GetMedicationRule(){
        List<SubRule> subrules= new ArrayList<>();
        subrules.add(new SubRule(1,0,true,false));
        subrules.add(new SubRule(1,1,2,5,false,new AlgorithmCommand("boolean","isclcrknown")));
        subrules.add(new SubRule(1,2,6,3,false,new AlgorithmCommand("integer","lastclcr",">",13)));
        subrules.add(new SubRule(1,3,0,4,false,new AlgorithmCommand("integer","clcr",">",30)));
        subrules.add(new SubRule(1,4,6,6,false,new AlgorithmCommand("integer","clcr",">",10)));
        subrules.add(new SubRule(1,5,6,0,false,new AlgorithmCommand("integer","clcr",">",70)));
        subrules.add(new SubRule(1,6,true,true));
        MedicationRule rule = new MedicationRule(1,subrules);
        return rule;
    }
}
