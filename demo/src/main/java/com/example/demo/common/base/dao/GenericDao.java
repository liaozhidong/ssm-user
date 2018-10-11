package com.example.demo.common.base.dao;

import com.example.demo.common.base.entity.QueryBase;

import java.util.List;

/**
 * Dao通用模板
 * lzd
 */
public interface GenericDao <T,Q extends QueryBase>{

    /**
     * 根据主键值获取对象
     */
    T get(T entity);

    /**
     * 获取全部实体
     */
    List<T> loadAll();

    /**
     * 查找是否存在
     */
    int isExist(Q queryModel);

    /**
     * 保存
     */
    int save(T entity) throws Exception;

    /**
     * 修改
     */
    int update(T entity) throws Exception;

    /**
     * 删除
     */
    int delete(T entity) throws Exception;

    /**
     * 分页查询
     */
    List<T> findByPage(Q queryModel);

    /**
     * 统计
     */
    int count(Q queryModel);

    /**
     * 查询
     * 查询条件
     */
    List<T> query(Q queryModel);

    /**
     * 根据id数组删除记录
     * 批量删除
     */
    int deleteByIds(String[] ids) throws Exception;

















}
