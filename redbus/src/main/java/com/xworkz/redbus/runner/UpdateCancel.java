package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.CancelEntity;

import javax.persistence.*;

public class UpdateCancel {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            CancelEntity entity=em.find(CancelEntity.class,1);
            System.out.println("Before update: " + entity);
            if(entity != null){
                entity.setReason("Mis Booking");
                CancelEntity updatedEntity = em.merge(entity);
                System.out.println("After update: " + updatedEntity);
                et.commit();
            }
        }catch(PersistenceException e){
            e.getMessage();
        }finally{
            if(emf != null){
                emf.close();
            }
            if(em != null){
                em.close();
            }
        }

    }
}
