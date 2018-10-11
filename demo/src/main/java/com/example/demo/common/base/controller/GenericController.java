package com.example.demo.common.base.controller;

import com.example.codeUtil.GenCodeUtil;
import com.example.demo.common.base.constant.SystemStaticConst;
import com.example.demo.common.base.entity.QueryBase;
import com.example.demo.common.base.service.GenericService;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class GenericController<T, Q extends QueryBase> {

    //抽象方法
    protected abstract GenericService<T, Q> getService();

    /**
     * 添加页面路径
     */
    public final static String ADDPAGE="/add";
    /**
     * 修改页面路径
     */
    public final static String UPDATEPAGE="/update";

    /**
     *  Controller 基路径
     */
    protected String basePath;

    /**
     * 抽象方法，获取页面基路径
     */
    protected String getPageBaseRoot() throws Exception {
        if (basePath == null) {
            basePath =this.getClass().getName();
            Pattern p  = Pattern.compile(".[a-z|A-z]+.controller.[a-z|A-z]+Controller");
            Matcher m = p.matcher(basePath);
            if (m.find()) {
                basePath = m.group();
                basePath = basePath.substring(1,basePath.length()-10);
                basePath = basePath.replace(".","/");
                basePath = basePath.replace("/controller/","/");
                basePath = basePath.substring(0,basePath.lastIndexOf("/")+1)+ GenCodeUtil.toFirstCharLowerCase(basePath.substring(basePath.lastIndexOf("/")+1));
            }
            else {
                throw new Exception("获取页面基路径失败");
            }
        }
        return basePath;
    }

    /**
     * 功能描述：直接跳转到更新数据的页面
     */
    @RequestMapping(value = "/updatePage",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updatePage(T entity, Model model) throws Exception {
        entity = getService().get(entity);
        model.addAttribute("entity",entity);
        return getPageBaseRoot()+UPDATEPAGE;
    }

    /**
     * 跳转到添加对象页面
     */
    @RequestMapping(value = "/addPage")
    public String addPage() throws Exception{
        return getPageBaseRoot()+ ADDPAGE;
    }

    /**
     * 功能描述：保存数据字典数据
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> save(T entity) throws Exception{
        boolean success = getService().save(entity);
        Map<String,Object> result = new HashMap<String, Object>();
        if (success==true) {
            result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
            result.put(SystemStaticConst.MSG,"增加数据成功！");
            result.put("entity",entity);
        }else {
            result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
            result.put(SystemStaticConst.MSG,"增加数据失败！");
        }
        return null;
    }

    /**
     * 功能描述：更新数据字典数据
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String,Object> update(T entity) throws Exception{
        boolean success = getService().update(entity);
        Map<String,Object> result = new HashMap<String, Object>();
        if (success==true) {
            result.put(SystemStaticConst.RESULT,SystemStaticConst.SUCCESS);
            result.put(SystemStaticConst.MSG,"更新数据成功！");
            result.put("entity",entity);
        }else {
            result.put(SystemStaticConst.RESULT,SystemStaticConst.FAIL);
            result.put(SystemStaticConst.MSG,"更新数据失败！");
        }
        return result;
    }
}
