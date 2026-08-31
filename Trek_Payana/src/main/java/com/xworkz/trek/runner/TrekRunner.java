package com.xworkz.trek.runner;

import com.xworkz.trek.dto.TrekDTO;
import com.xworkz.trek.entity.TrekEntity;
import com.xworkz.trek.service.TrekService;
import com.xworkz.trek.service.impl.TrekServiceImpl;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrekRunner {
    public static void main(String[] args) {

        EntityManagerFactory emf=null;
        EntityManager em=null;

        try{
            emf= Persistence.createEntityManagerFactory("x-workz");
            em=emf.createEntityManager();

            TypedQuery<TrekEntity> query=em.createNamedQuery("getAllTrekDetail", TrekEntity.class);
            List<TrekEntity> dto=query.getResultList();
            System.out.println("All Trek Details:");
            for(TrekEntity t:dto){
                System.out.println(t);
            }

//            TypedQuery<TrekEntity> query1=em.createNamedQuery("getByPlace", TrekEntity.class);
//            query1.setParameter("trekPlace","Belagavi");
//            List<TrekEntity> dto1=query1.getResultList();
//            System.out.println("Get By Place");
//            dto1.forEach(place -> System.out.println(place));

        }catch (PersistenceException e){
            e.getMessage();
        }finally{
            if(emf!=null){
                emf.close();
            }
            if(em!=null){
                em.close();
            }

        }
        List<TrekDTO> list=new ArrayList<>();
        list.add(new TrekDTO("KumarParvata", LocalDate.of(2025,02,26),10));
        list.add(new TrekDTO("Kudure Mukha", LocalDate.of(2026,03,18),8));
        list.add(new TrekDTO("Shrishalam", LocalDate.of(2026,04,8),12));

        TrekService service=new TrekServiceImpl();
        service.validateAndSaveAll(list);

        TrekDTO trekDTO=new TrekDTO("Belagavi",LocalDate.of(2025,02,26),2);
        TrekService service2=new TrekServiceImpl();
        service2.validateAndSave(trekDTO);

        TrekDTO dto=service2.findById(1);
        System.out.println("DTO Found:"+dto);

    }
}
