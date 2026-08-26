package com.xworkz.Event.dao.impl;

import com.xworkz.Event.dao.EventDetailDAO;
import com.xworkz.Event.entity.EventEntity;

import javax.persistence.*;

public class EventDetailDAOImpl implements EventDetailDAO {
    @Override
    public Boolean save(EventEntity eventEntity) {
        System.out.println("EventDetailDAOImpl save");
        boolean result = false;
        System.out.println("Event Entity: " + eventEntity);

        if(eventEntity != null) {

            EntityManagerFactory emf = null;
            EntityManager em = null;
            EntityTransaction et = null;

            try {
                emf = Persistence.createEntityManagerFactory("x-workz");
                em = emf.createEntityManager();
                et = em.getTransaction();
                et.begin();
                em.persist(eventEntity);
                et.commit();

                result = true;
                System.out.println(eventEntity);
                System.out.println("Data saved Successfully");
            } catch (PersistenceException e) {
               if(et!=null) {
                   et.rollback();
               }
               e.printStackTrace();
                System.out.println("Data save Failed");
            } finally {
                if (emf != null) {
                    emf.close();
                }
                if (em != null) {
                    em.close();
                }
            }
        }
        else {
            System.out.println("Failed,Entity is null");
        }
        return result;
    }

}
