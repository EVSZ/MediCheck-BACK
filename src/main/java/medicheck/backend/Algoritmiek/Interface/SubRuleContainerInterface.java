package medicheck.backend.Algoritmiek.Interface;

import medicheck.backend.DTO.SubRuleDTO;

import java.util.List;

public interface SubRuleContainerInterface
{
    public List<SubRuleDTO> GetSubRulesByParentRule(long parentRule);
}
