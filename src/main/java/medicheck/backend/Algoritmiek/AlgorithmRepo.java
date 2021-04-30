package medicheck.backend.Algoritmiek;

import medicheck.backend.Algoritmiek.Entities.SubRuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlgorithmRepo extends JpaRepository<SubRuleEntity, Long>
{
    List<SubRuleEntity> FindByParentRule(long parentRule);
}
