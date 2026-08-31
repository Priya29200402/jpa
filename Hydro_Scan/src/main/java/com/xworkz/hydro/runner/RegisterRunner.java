package com.xworkz.hydro.runner;

import com.xworkz.hydro.dto.RegisterDTO;
import com.xworkz.hydro.entity.RegisterEntity;
import com.xworkz.hydro.service.RegisterService;
import com.xworkz.hydro.service.impl.RegisterServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class RegisterRunner {
    public static void main(String[] args) {

        //Storing single value
        RegisterDTO registerDTO=new RegisterDTO("PRIYANKA","priya@email.com",6364838351l,"Priya@29","Priya@29");
        RegisterService service=new RegisterServiceImpl();
        service.validateAndSave(registerDTO);

        //Storing Multiple Values
        List<RegisterDTO> list=new ArrayList<>();
        list.add(new RegisterDTO("Hemanth","H@email.com",6364838351l,"Priya@29","Priya@29"));
        list.add(new RegisterDTO("Harshita","h@gmail.com",457896214l,"Harshita@29","Harshita@29"));
        list.add(new RegisterDTO("Akasha","A@gmail.com",9353220519l,"Akasha@07","Akasha@07"));

        RegisterService service2=new RegisterServiceImpl();
        service2.validateSaveAll(list);

        //Finding dto by id
        RegisterDTO dto2=service2.findById(registerDTO.getId());
        System.out.println("DTO Found:"+dto2);

    }
}
