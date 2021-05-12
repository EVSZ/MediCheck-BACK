package medicheck.backend.Algoritmiek;

import medicheck.backend.APIs.RequestModels.PatientModel;
import medicheck.backend.Algoritmiek.Algorithm.AlgorithmCommand;
import medicheck.backend.Algoritmiek.Algorithm.SubRule;
import medicheck.backend.Algoritmiek.Algorithm.SubRuleContainer;
import medicheck.backend.DAL.PatientDAL;
import medicheck.backend.Logic.Models.medicine.Medicine;
import medicheck.backend.Logic.Models.patient.Patient;
import medicheck.backend.Logic.Models.patient.PatientContainer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdviceGenerator
{

    public boolean advice = false;
    RuleSelector ruleSelector;
    CommandTranslator translator;
    List<MedicationRule> rulesToCheck;
    Patient patient;
    PatientContainer container;


    public AdviceGenerator(PatientContainer container)
    {
        this.container = container;
        ruleSelector= new RuleSelector();
        translator = new CommandTranslator();
        rulesToCheck = new ArrayList<>();
    }

    public boolean GenerateAdvice(List<Medicine> medication, long patientID)
    {
        patient = container.GetPatientByID(patientID);
        boolean result = false;
        boolean finished = false;

        RetrieveMedicationRules(ruleSelector.CheckForRules(medication));
        for (MedicationRule rule : rulesToCheck)
        {
            for (int i = 1; i < rule.subRules.size(); )
            {
                if (rule.subRules.get(i).isResult)
                {
                    result = rule.subRules.get(i).result;
                    finished = true;
                    break;
                }
                if (ExecuteCommand(rule.subRules.get(i).command))
                {
                    i = rule.subRules.get(i).ifTrue;
                } else
                    i = rule.subRules.get(i).ifFalse;
            }
            if (finished)
                break;

        }
        return result;
    }

    public boolean ExecuteCommand(AlgorithmCommand command)
    {

        switch (translator.TranslateCommandType(command.commandType))
        {

            case 1:
                return CompareInteger(command);
            case 2:
                return LogicalTest(command);
        }
        return false;

    }
    public boolean LogicalTest(AlgorithmCommand command)
    {
        return translator.TranslateLogicalTest(command.variableToCheck, patient);
    }

    public boolean CompareInteger(AlgorithmCommand command)
    {
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

    public void RetrieveMedicationRules(List<Long> ruleNumbers)
    {
        SubRuleContainer subRuleContainer = new SubRuleContainer(new AlgorithmDAL());
        for (Long ruleNumber : ruleNumbers)
        {
            MedicationRule medRule = new MedicationRule(ruleNumber, subRuleContainer.GetSubRulesByParentRule(ruleNumber));
            rulesToCheck.add(medRule);
        }
    }



}

