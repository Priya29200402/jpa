package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.BookingEntity;

import javax.persistence.*;

public class ReadBooking {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            BookingEntity entity=em.find(BookingEntity.class, 1);
            System.out.println(entity);

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
