package medicheck.backend.Algoritmiek.Entities;

import lombok.Getter;

import javax.persistence.*;

@Entity @Getter
public class AlgorithmCommandEntity
{
    @Id
    @GeneratedValue
    long ID;

    @Column
    String variableToCheck;

    @Column
    String constraint;

    @Column(nullable = false)
    String commandType;

    @Column
    int valueToCompare;
}
