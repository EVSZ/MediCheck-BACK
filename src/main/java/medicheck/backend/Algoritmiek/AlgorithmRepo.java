package medicheck.backend.Algoritmiek;

import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlgorithmRepo extends JpaRepository<SubRuleEntity, Long>
{
    SubRuleEntity FindByParentRule(long parentRule);
}
