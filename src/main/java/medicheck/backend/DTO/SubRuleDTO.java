package medicheck.backend.DTO;

import lombok.Getter;
import lombok.Setter;
import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import medicheck.backend.Algoritmiek.SubRule;

@Getter @Setter
public class SubRuleDTO
{
    long ID;
    int parentRule;
    int ruleNumber;
    int ifTrue;
    int ifFalse;
    boolean isResult;
    boolean result;
    AlgorithmCommandDTO Command;

    public SubRuleDTO(SubRule subRule)
    {
        ID = subRule.getID();
        parentRule = subRule.getParentRule();
        ruleNumber = subRule.getRuleNumber();
        ifTrue = subRule.getIfTrue();
        ifFalse = subRule.getIfFalse();
        isResult = subRule.isResult();
        result = subRule.isResult();
        Command = new AlgorithmCommandDTO(subRule.getCommand());
    }
    public SubRuleDTO(SubRuleEntity subRuleEntity)
    {
        ID = subRuleEntity.getID();
        parentRule = subRuleEntity.getParentRule();
        ruleNumber = subRuleEntity.getRuleNumber();
        ifTrue = subRuleEntity.getIfTrue();
        ifFalse = subRuleEntity.getIfFalse();
        isResult = subRuleEntity.isResult();
        result = subRuleEntity.isResult();
        Command = new AlgorithmCommandDTO(subRuleEntity.getCommand());
    }
}
