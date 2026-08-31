package com.xworkz.digital.dao.impl;

import com.xworkz.digital.dao.ProductDAO;
import com.xworkz.digital.entity.ProductEntity;

import javax.persistence.*;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    @Override
    public Boolean save(ProductEntity entity) {
        System.out.println("Invoking save");
        Boolean isSaved=false;
        System.out.println("Entity:"+entity);

        EntityManagerFactory emf =null;
        EntityManager em = null;
        EntityTransaction et= null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();
            em.persist(entity);
            et.commit();
        } catch (PersistenceException e) {
            e.getMessage();
            e.printStackTrace();
        }finally {
            if(emf != null){
                emf.close();
            }
            if(em != null){
                em.close();
            }
        }
        return isSaved;
    }

    @Override
    public Boolean saveAll(List<ProductEntity> entityList) {
        System.out.println("Invoking saveAll");
        Boolean isSaved=false;
        System.out.println("Entity:"+entityList);
        EntityManagerFactory emf =null;
        EntityManager em = null;
        EntityTransaction et= null;

        try{
            emf=Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();
            et=em.getTransaction();
            et.begin();

            for(ProductEntity entity:entityList){
                em.persist(entity);
            }
            isSaved=true;
            et.commit();
        }catch (PersistenceException e){
            e.getMessage();
            isSaved=false;
        }finally {
            if(emf != null){
                emf.close();
            }
            if(em != null){
                em.close();
            }
        }
        return isSaved;
    }

    @Override
    public ProductEntity getProductEntityByIdAndName(Integer id,String name) {
        ProductEntity productEntity=null;
        EntityManagerFactory emf =null;

        try{
            productEntity=Persistence.createEntityManagerFactory("x-workz").createEntityManager().find(ProductEntity.class, id);

        }catch (PersistenceException e){
            e.printStackTrace();
            productEntity=null;
        }finally {
            if(emf != null){
                emf.close();
            }
        }
        return productEntity;
    }
}
