package medicheck.backend.Algoritmiek;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.SecondaryTable;

@Getter @Setter
public class SubRule
{
    long ID;
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
