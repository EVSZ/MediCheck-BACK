package medicheck.backend.Algoritmiek;

import medicheck.backend.patient.Patient;

public class RuleReader
{
    public void Read(MedicationRule medicationRule)
    {
        TestPatient patient = new TestPatient();
        for (int i = 0; i < medicationRule.rules.size();)
        {
            Rule rule = medicationRule.rules.get(i);

            if (rule.algorithmCommand.variable.equals("age")){
                var ding = patient.age;
                ExecuteAlgorithmCommand(rule.algorithmCommand);
            }

            if (ding > rule.algorithmCommand.amount)
            {

                i = rule.ifTrue;
            }
            else
            {
                i = rule.ifFalse;
            }
        }
    }
    public void ExecuteAlgorithmCommand(AlgorithmCommand command, var ding){

    }

}
