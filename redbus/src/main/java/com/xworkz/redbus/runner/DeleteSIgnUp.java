package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class DeleteSIgnUp {
    public static void main(String[] args) {

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try {
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();

            SignUpEntity entity=em.find(SignUpEntity.class,1);
            if(entity != null){
                et.begin();
                em.remove(entity);
                System.out.println("Data Deleted Successfully");
                et.commit();

            }
        }catch (PersistenceException e){
            et.rollback();
            e.printStackTrace();
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
