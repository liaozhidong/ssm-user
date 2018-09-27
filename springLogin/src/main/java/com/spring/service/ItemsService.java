package com.spring.service;

import com.spring.entity.Items;

import java.util.List;

/**
 * lzd
 */
public interface ItemsService {

    Items findOne(int id);

    List<Items> findAll();

    void add(Items items);

    void upd(Items items);

    void del(int id);

}
