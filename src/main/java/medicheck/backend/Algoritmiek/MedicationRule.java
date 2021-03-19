package medicheck.backend.Algoritmiek;
import java.util.ArrayList;
import java.util.List;

import medicheck.backend.patient.HealthInformation;

public class MedicationRule {

    List<Rule> rules = new ArrayList<Rule>();


    //Hardcoded kennisregels
    public boolean Rule1(HealthInformation healthInfo, Integer age) {
        if (healthInfo.clcr != 0)
        {
            if (healthInfo.monthsSinceLastclcr > 13)
            {
                return true;
            }
            else return healthInfo.clcr <= 30;
        } else return age >= 70;
    }

    public boolean Rule2(HealthInformation healthInfo) {
        return !LaxansCheck();
    }
    boolean LaxansCheck(){
//        if (patient.getMedication().contains("Laxans")){
//            return true;
//        }
        return false;
    }
    boolean LoperamideCheck(){
        //        if (patient.getMedication().contains("Loperamide")){
//            return true;
//        }
        return false;

    }
}
