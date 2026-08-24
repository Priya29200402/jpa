package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.HotelEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadHotel {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            HotelEntity hotelEntity=em.find(HotelEntity.class, 1);
            System.out.println(hotelEntity);
        }catch (PersistenceException e){
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
