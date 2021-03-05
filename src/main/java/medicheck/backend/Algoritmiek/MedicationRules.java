package medicheck.backend.Algoritmiek;

import medicheck.backend.patient.HealthInformation;

public class MedicationRules {
    public boolean Rule1(HealthInformation healthInfo, Integer age) {
        if (healthInfo.clcr != 0)
        {
            if (healthInfo.monthsSinceLastclcr > 13)
            {
                return true;
            } else if (healthInfo.clcr > 30)
            {
                return false;
            } else return true;
        } else if (age >= 70)
        {
            return true;
        }
        return false;
    }

    public boolean Rule2(HealthInformation healthInfo) {
        if (LaxansCheck())
        {
            return false;
        }
        return true;

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
