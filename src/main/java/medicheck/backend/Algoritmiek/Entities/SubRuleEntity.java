package medicheck.backend.Algoritmiek.Entities;

import lombok.Getter;
import medicheck.backend.DAL.DataModels.PatientDataModel;

import javax.persistence.*;

@Entity @Getter
@NamedNativeQuery(
        name="SubRuleEntity.FindByParentRule",
        query = "SELECT * FROM Sub WHERE parentRule = ?",
        resultClass = SubRuleEntity.class
)
public class SubRuleEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long ID;

    @Column(nullable = false)
    int parentRule;

    @Column(nullable = false)
    int ruleNumber;

    @Column
    int ifTrue;

    @Column
    int ifFalse;

    @Column(nullable = false)
    boolean hasResult;

    @Column
    boolean result;

    @ManyToOne
    @JoinColumn
    AlgorithmCommandEntity Command = new AlgorithmCommandEntity();
}
