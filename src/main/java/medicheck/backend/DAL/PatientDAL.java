package medicheck.backend.DAL;

import medicheck.backend.DAL.DataModels.PatientDataModel;
import medicheck.backend.DAL.Interfaces.IAuthentication;
import medicheck.backend.DAL.Interfaces.IPatientContainer;
import medicheck.backend.DAL.Interfaces.IPatient;
import medicheck.backend.DAL.Repos.PatientRepo;
import medicheck.backend.DTO.AccountDTO;
import medicheck.backend.DTO.PatientDTO;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientDAL implements IPatientContainer, IPatient, IAuthentication
{
    static EntityManagerFactory factory = Persistence.createEntityManagerFactory("MediCheck-BACK");
    EntityTransaction transaction;
    EntityManager manager;

    public PatientDTO GetInlogPatient(String Username, String Password)
    {
        manager  = factory.createEntityManager();
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<PatientDataModel> query = builder.createQuery(PatientDataModel.class);
        Root<PatientDataModel> root = query.from(PatientDataModel.class);

        Predicate predicateUsername
                = builder.like(root.get("Username"), Username);
        Predicate predicatePassword
                = builder.like(root.get("Password"), Password);
        Predicate predicateLogIn
                = builder.and(predicateUsername, predicatePassword);

        query.select(root).where(predicateLogIn);

        try
        {
            return new PatientDTO(manager.createQuery(query).getSingleResult());
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
            return null;
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
        }
    }

    public PatientDTO GetPatient(long patientID)
    {
        manager  = factory.createEntityManager();
        String query = "SELECT patient FROM PatientDataModel patient WHERE patient.id = :id";

        TypedQuery<PatientDataModel> tq = manager.createQuery(query, PatientDataModel.class);
        tq.setParameter("id",patientID);

        try
        {
            return new PatientDTO(tq.getSingleResult());
        }
        catch (NoResultException ex)
        {
            System.out.println("ex");
            return null;
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
        }
    }

    public void SavePatient(PatientDTO patientDTO)
    {
        manager  = factory.createEntityManager();
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            PatientDataModel patientDataModel = new PatientDataModel(patientDTO);
            manager.persist(patientDataModel);
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }
    public void UpdatePatient(PatientDTO patientDTO)
    {
        manager  = factory.createEntityManager();
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            PatientDataModel patient = manager.find(PatientDataModel.class, patientDTO.getId());
            patient.getPrescriptions().clear();
            patient = new PatientDataModel(patientDTO);
            manager.merge(patient);
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }

    public void RegisterPatient(AccountDTO patientDTO)
    {
        manager  = factory.createEntityManager();
        try
        {
            manager = factory.createEntityManager();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(new PatientDataModel(patientDTO));
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }

    public void DeletePatient(PatientDTO patientDTO)
    {
        manager  = factory.createEntityManager();
        try
        {
            transaction = manager.getTransaction();
            transaction.begin();
            manager.remove(new PatientDataModel(patientDTO));
            transaction.commit();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            transaction.rollback();
        }
        finally
        {
            if(manager.isOpen())
            {
                manager.close();
            }
            transaction = null;
        }
    }
}
