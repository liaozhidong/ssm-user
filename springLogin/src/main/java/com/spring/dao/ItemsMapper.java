package com.spring.dao;

import com.spring.entity.Items;

import java.util.List;

public interface ItemsMapper {

    Items findOne(int id);

    List<Items> findAll();

    void add(Items items);

    void upd(Items items);

    void del(int id);

}
