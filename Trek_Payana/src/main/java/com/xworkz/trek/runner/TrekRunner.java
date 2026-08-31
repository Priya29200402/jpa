package com.xworkz.trek.runner;

import com.xworkz.trek.dto.TrekDTO;
import com.xworkz.trek.service.TrekService;
import com.xworkz.trek.service.impl.TrekServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TrekRunner {
    public static void main(String[] args) {
        List<TrekDTO> list=new ArrayList<>();
        list.add(new TrekDTO("KumarParvata", LocalDate.of(2025,02,26),10));
        list.add(new TrekDTO("Kudure Mukha", LocalDate.of(2026,03,18),8));
        list.add(new TrekDTO("Shrishalam", LocalDate.of(2026,04,8),12));

        TrekService service=new TrekServiceImpl();
        service.validateAndSave(list);

    }
}
