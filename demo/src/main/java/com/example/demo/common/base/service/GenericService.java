package com.example.demo.common.base.service;

import com.example.demo.common.base.dao.GenericDao;
import com.example.demo.common.base.entity.Page;
import com.example.demo.common.base.entity.QueryBase;

import java.util.List;

/**
 * 通用Service
 * lzd
 * @param <T>
 * @param <Q>
 */
public abstract class GenericService  <T,Q extends QueryBase> {

    protected abstract GenericDao<T,Q> getDao();

    /**
     * 根据主键值获取对象
     * @param entity
     * @return
     */
    public T get(T entity){ return getDao().get(entity); }

    /**
     * 获取全部对象
     * @return
     */
    public List<T> loadAll() { return getDao().loadAll(); }

    /**
     * 查找是否存在
     * @param queryModel 查询条件
     * @return
     */
    public boolean isExist(Q queryModel) { return  getDao().isExist(queryModel)>0; }

    /**
     * 保存
     * @param entity
     * @return
     * @throws Exception
     */
    public boolean save(T entity) throws  Exception{
        return getDao().save(entity)>0;
    }

    /**
     * 更新
     * @param entity
     * @return
     * @throws Exception
     */
    public boolean update(T entity) throws Exception{
        return getDao().update(entity)>0;
    }

    /**
     * 删除
     * @param entity
     * @return
     * @throws Exception
     */
    public boolean delete(T entity) throws Exception{
        return getDao().delete(entity)>0;
    }

    /**
     * 分页查询
     * @param queryModel
     * @return
     */
    public Page findByPage(Q queryModel){
        List<T> list = getDao().findByPage(queryModel);
        int count = getDao().count(queryModel);
        return new Page(list,count);
    }

    /**
     * 查询条件
     * @param queryModel
     * @return
     */
    public int count(Q queryModel) {
        return getDao().count(queryModel);
    }

    /**
     * 查询
     * @param queryModel
     * @return
     */
    public List<T> query(Q queryModel) {
        return getDao().query(queryModel);
    }

    /**
     * 根据id数组删除记录
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean deleteByIds(String[] ids) throws Exception{
        return getDao().deleteByIds(ids)>0;
    }

    public boolean removeBath(List<T> entityList) throws Exception {
        for (T t:entityList) {
            if (!delete(t)){
                return false;
            }
        }
        return true;
    }


}
