//package medicheck.backend.Algoritmiek;
//
//import medicheck.backend.patient.Patient;
//
//public class RuleReader
//{
//    TestPatient patient;
//    public void Read(MedicationRule medicationRule)
//    {
//        patient = new TestPatient();
//        for (int i = 0; i < medicationRule.rules.size();)
//        {
//            Rule rule = medicationRule.rules.get(i);
//
//            boolean result = ExecuteAlgorithmCommand(rule.algorithmCommand);
//            if(rule.hasEndPoint)
//            {
//                if (result)
//                {
//                    i = rule.ifTrue;
//                }
//                else
//                {
//                    i = rule.ifFalse;
//
//                }
//            }
//            else
//            {
//
//            }
//        }
//    }
//    public boolean ExecuteAlgorithmCommand(AlgorithmCommand command){
//        CommandTranslator translator = new CommandTranslator(patient);
//        translator.TranslateCommand(command);
//
//        if (translator.TranslateConstraint(command.constraint) == 1){
//            if(translator.TranslateVariableInteger(command.variable) > command.amount){
//                return true;
//            }
//            return false;
//        }
//        return false;
//    }
//
//}
