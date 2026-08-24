package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.HotelEntity;

import javax.persistence.*;
import java.time.LocalDate;

public class CreateHotel {
    public static void main(String[] args) {
        HotelEntity hotelEntity=new HotelEntity();
        hotelEntity.setCityName("Bangalore");
        hotelEntity.setCheckInDate(LocalDate.of(2024, 12, 25));
        hotelEntity.setCheckOutDate(LocalDate.of(2024, 12, 30));
        hotelEntity.setNoOfGuest(4);

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et =null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz"); // load , register,connection
            em=emf.createEntityManager(); //DML,DQl
            et=em.getTransaction(); //TCL
            et.begin(); // setautocommit =0
            // DML--> insert,update,delete

            em.persist(hotelEntity); // insert
            System.out.println("Data Saved:"+hotelEntity);
            et.commit(); //commit
        }catch (PersistenceException e){
            et.rollback();
            e.getMessage();
        }finally {
            if (emf !=null){
                emf.close();
            }

            if(em !=null){
                em.close();
            }
        }

    }
}
