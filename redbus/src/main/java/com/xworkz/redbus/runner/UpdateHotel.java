package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.HotelEntity;
import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class UpdateHotel {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em =null;
        EntityTransaction et =null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            HotelEntity hotelEntity = em.find(HotelEntity.class,1);
            System.out.println("Before Update:"+hotelEntity);
            if(hotelEntity != null){
                hotelEntity.setCityName("Mysore");
                hotelEntity.setNoOfGuest(5);
                HotelEntity updatedHotelEntity = em.merge(hotelEntity);
                System.out.println("After Updated:"+updatedHotelEntity);
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
