package medicheck.backend.Algoritmiek;

import medicheck.backend.patient.Patient;
import medicheck.backend.patient.PatientModel;

import java.util.ArrayList;
import java.util.List;

public class AdviceGenerator
{

    public boolean advice = false;
    RuleSelector ruleSelector;
    CommandTranslator translator;
    List<MedicationRule> rulesToCheck;
    MedicationRuleContainer container;
    TestPatient patient;


    public AdviceGenerator()
    {
        ruleSelector= new RuleSelector();
        translator = new CommandTranslator();
        rulesToCheck = new ArrayList<>();
        container = new MedicationRuleContainer();
    }


    public boolean GenerateAdvice(TestPatient testPatient)
    {
        patient = testPatient;
        rulesToCheck.add(container.GetMedicationRule());
        //RetrieveMedicationRules(ruleSelector.CheckForRules(patient.medication));
        for (MedicationRule rule : rulesToCheck)
        {
            for (int i = 1; i < rule.subRules.size();)
            {
                if (rule.subRules.get(i).isResult){
                    return rule.subRules.get(i).result;
                }
                if(ExecuteCommand(rule.subRules.get(i).command)){
                    i = rule.subRules.get(i).ifTrue;
                }
                else i = rule.subRules.get(i).ifFalse;
            }

        }
        return false;
    }
    public boolean ExecuteCommand(AlgorithmCommand command){

        switch (translator.TranslateCommandType(command.commandType))
        {

            case 1:
                return CompareInteger(command);
            case 2:
                return LogicalTest(command);
        }
        return false;

    }
    public boolean LogicalTest(AlgorithmCommand command){
        return translator.TranslateLogicalTest(command.variableToCheck, patient);
    }

    public boolean CompareInteger(AlgorithmCommand command){
        int integerToCompare = translator.TranslateCommandVariableToInteger(command.variableToCheck, patient);
        switch (translator.TranslateConstraint(command.constraint)){
            case 1:
                if (integerToCompare > command.valueToCompare)
                {
                    return true;
                }
                break;
            case 2:
                if (integerToCompare < command.valueToCompare){
                    return true;
                }
                break;
        }
        return false;
    }
    public String TestAdvice(){
        return "boterham";
    }
    public String GetAdvice(PatientModel patient)
    {
        String advice = "";

        return advice;
    }
    public void RetrieveMedicationRules(List<Long> ruleNumbers){
    for (Long ruleNumber : ruleNumbers)
    {
        rulesToCheck.add(container.GetMedicationRule());
    }
}



}

