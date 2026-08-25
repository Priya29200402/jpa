package com.xworkz.redbus.runner;

import com.xworkz.redbus.entity.FeedbackEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class ReadFeedback {
    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em = emf.createEntityManager();
            FeedbackEntity feedbackEntity = em.find(FeedbackEntity.class, 1);
            System.out.println("Entity Found:"+feedbackEntity);
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
