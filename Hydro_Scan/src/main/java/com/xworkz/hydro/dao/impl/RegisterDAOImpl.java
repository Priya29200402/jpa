package com.xworkz.hydro.dao.impl;

import com.xworkz.hydro.dao.RegisterDAO;
import com.xworkz.hydro.entity.RegisterEntity;

import javax.persistence.*;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {
    @Override
    public Boolean save(RegisterEntity registerEntity) {
        System.out.println("Invoking save");
        Boolean result=false;
        System.out.println("Entity:"+registerEntity);

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            em.persist(registerEntity);

            et.commit();
        }catch(PersistenceException e){
            e.getMessage();
            e.printStackTrace();
        }finally{
            if(emf != null){
                emf.close();
            }
            if(em != null){
                em.close();
            }
        }

        return result;
    }

    @Override
    public Boolean saveAll(List<RegisterEntity> registerEntitys) {
        System.out.println("Invoking saveAll");
        Boolean result=false;
        System.out.println("Entity List:"+registerEntitys);

        EntityManagerFactory emf=null;
        EntityManager em=null;
        EntityTransaction et=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();

            et.begin();

            for(RegisterEntity registerEntity:registerEntitys){
                em.persist(registerEntity);
            }
            result=true;
            et.commit();
        }catch(PersistenceException e){
            if(emf != null){
                emf.close();
            }
            if(em !=null){
                em.close();
            }
        }
        return result;
    }

    @Override
    public RegisterEntity findById(Integer id) {
        System.out.println("Invoking findById:"+ id);
        RegisterEntity registerEntity=null;
        EntityManagerFactory emf=null;

        try{
            registerEntity=Persistence.createEntityManagerFactory("x-workz").createEntityManager().find(RegisterEntity.class, id);
        }catch(PersistenceException e){
            e.printStackTrace();
            registerEntity=null;
        }finally{
            if(emf != null){
                emf.close();
            }
        }

        return registerEntity;
    }
}
