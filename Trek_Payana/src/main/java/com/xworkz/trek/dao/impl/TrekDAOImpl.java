package com.xworkz.trek.dao.impl;

import com.xworkz.trek.dao.TrekDAO;
import com.xworkz.trek.dto.TrekDTO;
import com.xworkz.trek.entity.TrekEntity;

import javax.persistence.*;
import java.util.List;

public class TrekDAOImpl implements TrekDAO {
    @Override
    public Boolean saveAll(List<TrekEntity> entity) {
        System.out.println("invoking saveAll");
        Boolean isSaved = false;
        System.out.println("Entity:"+entity);

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            for(TrekEntity trek:entity){
                em.persist(trek);
            }
            isSaved=true;
            et.commit();
        }catch (PersistenceException e){
            e.getMessage();
            isSaved=false;
        }finally {
            if(emf != null) {
                emf.close();
            }
            if(em != null){
                em.close();
            }
        }
        return isSaved;
    }

    @Override
    public String save(TrekEntity entity) {
        System.out.println("invoking save");
        String isSaved = null;
        System.out.println("Entity:"+entity);

        if(entity != null){
            EntityManagerFactory emf=null;
            EntityManager em=null;
            EntityTransaction et=null;

            try{
                emf= Persistence.createEntityManagerFactory("x-workz");
                em=emf.createEntityManager();
                et=em.getTransaction();
                et.begin();
                em.persist(entity);
                isSaved="success";
                et.commit();
            }catch (PersistenceException e){
                if (et !=null){
                    et.rollback();
                }
                e.printStackTrace();
                System.out.println("Data saving failed");
            }finally {
                if(emf != null) {
                    em.close();
                }
            }
        }else {
            System.out.println("Data is empty");
        }

        return isSaved;
    }

    @Override
    public TrekEntity getById(Integer id) {
        TrekEntity entity = null;
        EntityManagerFactory emf=null;

        try{
            entity=Persistence.createEntityManagerFactory("x-workz").createEntityManager().find(TrekEntity.class, id);

        }catch (PersistenceException e){
            e.printStackTrace();
            entity=null;
        }finally {
            if(emf !=null){
                emf.close();
            }
        }
        return entity;
    }

}
