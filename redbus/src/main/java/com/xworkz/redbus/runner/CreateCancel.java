package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.CancelEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class CreateCancel {
    public static void main(String[] args) {
        CancelEntity entity = new CancelEntity();
        entity.setTicketNumber(123456);
        entity.setReason("Change of plans");

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            em.persist(entity);
            System.out.println("Data Saved:"+entity);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            e.getMessage();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }

    }
}
