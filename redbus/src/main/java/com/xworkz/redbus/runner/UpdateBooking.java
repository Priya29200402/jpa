package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.BookingEntity;

import javax.persistence.*;

public class UpdateBooking {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et = em.getTransaction();
            et.begin();

            BookingEntity entity = em.find(BookingEntity.class,1);
            System.out.println("Before Update:"+entity);
            if(entity != null){
                entity.setFrom("Hubli");
                BookingEntity updatedEntity = em.merge(entity);
                System.out.println("After Update:"+updatedEntity);
                et.commit();
            }

        }catch (PersistenceException e){
            e.getMessage();
        }
        finally{
            if(emf != null){
                emf.close();
            }
            if(em!=null){
                em.close();
            }
        }
    }
}
