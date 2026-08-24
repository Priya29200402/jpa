package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.BookingEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class CreateBookingEntity {
    public static void main(String[] args) {
        BookingEntity entity = new BookingEntity();
        entity.setFrom("Banglore");
        entity.setTo("Belagavi");
        int year = 2026;
        int month = 2;
        int day = 29;
        LocalDate onWardDate;
        if (month == 2 && day == 29 && !java.time.Year.isLeap(year)) {
            // 2026 is not a leap year — fallback to Feb 28
            onWardDate = LocalDate.of(year, month, 28);
        } else {
            onWardDate = LocalDate.of(year, month, day);
        }
        entity.setOnWardDate(onWardDate);

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



        }catch (PersistenceException e){
            et.rollback();
            e.getMessage();
        }
        finally{
            if(emf != null){
                emf.close();
            }
            if(em !=null){
                em.close();
            }
        }
    }
}
