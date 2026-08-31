package com.xworkz.trek.dao;

import com.xworkz.trek.dto.TrekDTO;
import com.xworkz.trek.entity.TrekEntity;

import java.util.List;

public interface TrekDAO {

    Boolean saveAll(List<TrekEntity> entity);

    String save(TrekEntity entity);

    TrekEntity getById(Integer id);
}
