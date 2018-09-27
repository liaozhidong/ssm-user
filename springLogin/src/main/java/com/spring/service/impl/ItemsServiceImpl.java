package com.spring.service.impl;

import com.spring.dao.ItemsMapper;
import com.spring.entity.Items;
import com.spring.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public Items findOne(int id) {
        return itemsMapper.findOne(id);
    }

    @Override
    public List<Items> findAll() {
        return itemsMapper.findAll();
    }

    @Override
    public void add(Items items) {
        itemsMapper.add(items);
    }

    @Override
    public void upd(Items items) {
        itemsMapper.upd(items);
    }

    @Override
    public void del(int id) {
        itemsMapper.del(id);
    }
}
