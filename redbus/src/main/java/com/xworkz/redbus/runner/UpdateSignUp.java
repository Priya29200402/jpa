package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.SignUpEntity;

import javax.persistence.*;

public class UpdateSignUp {
    public static void main(String[] args) {
        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try {
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            SignUpEntity signUpEntity=em.find(SignUpEntity.class,1);
            System.out.println("Before Update: "+signUpEntity);
            if(signUpEntity != null){
                signUpEntity.setEmail("m@gmail.com");
                signUpEntity.setPassword("Priya@123");
                SignUpEntity updatedEntity= em.merge(signUpEntity);
                System.out.println("After Update: "+updatedEntity);
                et.commit();

            }


        }catch (PersistenceException e){
            e.getMessage();
        }
        finally {
            if(emf != null){
                emf.close();
            }
            if(em != null){
                em.close();
            }
        }

    }
}
