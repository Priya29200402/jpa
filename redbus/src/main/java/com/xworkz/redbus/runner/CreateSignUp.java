package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class CreateSignUp {

    public static void main(String[] args) {
        SignUpEntity signUpEntity = new SignUpEntity();
        signUpEntity.setEmail("priya@gmail.com");
        signUpEntity.setName("Priya");
        signUpEntity.setPassword("password");

        EntityManagerFactory emf = null;
        EntityManager em = null;
        EntityTransaction et = null;

        try
        {
            emf = Persistence.createEntityManagerFactory("x-workz");//load, register, connection
            em = emf.createEntityManager(); //DML, DQL
            et = em.getTransaction(); //TCL
            et.begin(); //set auto commit=0
            em.persist(signUpEntity); //DMl-Insert,Update,Delete
            et.commit();
            System.out.println("success");
        }
        catch (PersistenceException e)
        {
            if(et != null)
            {
                et.rollback();
            }
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(emf!=null)
            {
                emf.close();
            }
            if(em!=null)
            {
                em.close();
            }
        }
    }
}
