package com.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.spring.entity.Items;
import com.spring.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/queryItems")
    public String queryItems(@RequestParam(value="pn",defaultValue="1")Integer pn, Model model) {
        PageHelper.startPage(pn,5);
        List<Items> itemsList = itemsService.findAll();
        PageInfo<Items> pageInfo = new PageInfo<Items>(itemsList,5);
        model.addAttribute("pageInfo",pageInfo);
        return "showItems";
    }



//    @RequestMapping("/itemsList")
//    public List<Items> itemsList() {
//        return itemsService.findAll();
//    }

    //添加商品
    @RequestMapping("/addItems")
    public String addItems(Items items,MultipartFile items_pic,HttpServletRequest req) throws IllegalStateException, IOException{

        String path=req.getServletContext().getRealPath("/upload");

        String pic_name=items_pic.getOriginalFilename();

        String newname=UUID.randomUUID().toString()+
                pic_name.substring(pic_name.lastIndexOf("."));
        System.out.println(path);
        File picFile=new File(path,newname);

        if(!picFile.exists()){
            picFile.mkdirs();
        }

        items_pic.transferTo(picFile);
        items.setPic(newname);
        itemsService.add(items);
        return "redirect:queryItems.action";
    }
    //删除
    @RequestMapping("/del")
    public String del(int id) {
        itemsService.del(id);
        return "redirect:queryItems.action";
    }
    //查询单个
    @RequestMapping("/findOne")
    public String findOne(Model model,int id){
        Items items=itemsService.findOne(id);
        model.addAttribute("items", items);
        return "upd";
    }
    //修改
    @RequestMapping("/upd")
    public String upd(Items items,MultipartFile items_pic1,HttpServletRequest req) throws IllegalStateException, IOException{
        items.setPic(itemsService.findOne(items.getId()).getPic());
        String path=req.getServletContext().getRealPath("upload");
        String pic_name=items_pic1.getOriginalFilename();
        if(items_pic1!=null&&pic_name!=null&&pic_name.length()>0){
            String newname=UUID.randomUUID().toString()+
                    pic_name.substring(pic_name.lastIndexOf("."));
            File picFile=new File(path,newname);
            if(!picFile.exists()){
                picFile.mkdirs();
            }
            items_pic1.transferTo(picFile);
            items.setPic(newname);
        }
        itemsService.upd(items);
        return "redirect:queryItems.action";
    }
}
