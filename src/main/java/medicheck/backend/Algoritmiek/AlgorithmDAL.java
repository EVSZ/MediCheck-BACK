package medicheck.backend.Algoritmiek;

import medicheck.backend.Algoritmiek.DTO.SubRuleDTO;

public class AlgorithmDAL
{
    AlgorithmRepo repo;

    public SubRuleDTO GetAllSubRules(long parentRule)
    {
        return new SubRuleDTO(repo.FindByParentRule(parentRule));
    }
}
