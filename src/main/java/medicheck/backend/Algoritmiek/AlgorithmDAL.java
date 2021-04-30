package medicheck.backend.Algoritmiek;

import medicheck.backend.DTO.SubRuleDTO;

public class AlgorithmDAL
{
    AlgorithmRepo repo;

    public SubRuleDTO GetAllSubRules(long parentRule)
    {
        return new SubRuleDTO(repo.FindByParentRule(parentRule));
    }
}
