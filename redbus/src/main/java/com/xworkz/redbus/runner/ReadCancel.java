package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.CancelEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadCancel {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();

            CancelEntity entity=em.find(CancelEntity.class,1);
            System.out.println("Entity found: " + entity);

        }catch (PersistenceException e){
            e.getMessage();
        } finally{
            if(emf != null){
                emf.close();
            }
            if(em != null){
                em.close();
            }
        }
    }
}
