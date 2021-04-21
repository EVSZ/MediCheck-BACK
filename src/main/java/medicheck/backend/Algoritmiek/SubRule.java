package medicheck.backend.Algoritmiek;

public class SubRule
{
    int parentRule;
    int ruleNumber;
    int ifTrue;
    int ifFalse;
    boolean isResult;
    boolean result;
    AlgorithmCommand command;
    public SubRule(int parentRule, int ruleNumber, int ifTrue, int ifFalse, boolean isResult, AlgorithmCommand command)
    {
        this.parentRule = parentRule;
        this.ruleNumber = ruleNumber;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.isResult = isResult;
        this.command = command;
    }
    public SubRule(int parentRule, int ruleNumber, boolean isResult, boolean result)
    {
        this.parentRule = parentRule;
        this.ruleNumber = ruleNumber;
        this.isResult = isResult;
        this.result = result;

    }
}
