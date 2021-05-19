package medicheck.backend.Algoritmiek.Algorithm;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.DTO.SubRuleDTO;


@Getter @Setter
public class SubRule
{
    public long ID;
    public int parentRule;
    public int ruleNumber;
    public int ifTrue;
    public int ifFalse;
    public boolean hasResult;
    public boolean result;
    public AlgorithmCommand command;

    public SubRule(int parentRule, int ruleNumber, int ifTrue, int ifFalse, boolean isResult, AlgorithmCommand command)
    {
        this.parentRule = parentRule;
        this.ruleNumber = ruleNumber;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.hasResult = isResult;
        this.command = command;
    }

    public SubRule(int parentRule, int ruleNumber, boolean isResult, boolean result)
    {
        this.parentRule = parentRule;
        this.ruleNumber = ruleNumber;
        this.hasResult = isResult;
        this.result = result;

    }

    public SubRule(SubRuleDTO SubRule)
    {
        this.parentRule = SubRule.getParentRule();
        this.ruleNumber = SubRule.getRuleNumber();
        this.ifTrue = SubRule.getIfTrue();
        this.ifFalse = SubRule.getIfFalse();
        this.hasResult = SubRule.isHasResult();
        this.result = SubRule.isResult();
        this.command = new AlgorithmCommand(SubRule.getCommand());
    }
}
