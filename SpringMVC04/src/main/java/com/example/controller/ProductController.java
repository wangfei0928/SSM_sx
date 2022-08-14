package com.example.controller;

import com.example.bean.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @RequestMapping("/toList")
    public String list(Model model, Integer pageSize, Integer pageNo, HttpSession session){
        if (pageNo == null || pageNo.equals("")){
            pageNo = 1; //默认显示第一页
        }
        if (pageSize ==null|| pageSize.equals("")){
            pageSize = 5;
        }
        System.out.println(pageNo);
        List<Product> list = productService.getByPage(pageNo,pageSize);
        model.addAttribute("plist",list);
        Integer totalSize = productService.getTotal();
        session.setAttribute("totalSize",totalSize);
        return "list";
    }

    @RequestMapping("/toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("/add")
    public String add(String name, String price, MultipartFile file, HttpServletRequest request) throws IOException {
        if (name != null && price != null && file != null) {
            String oldProductImg = file.getOriginalFilename();//获取文件(图片)名称
            String suffix = oldProductImg.substring(oldProductImg.lastIndexOf(".")); // 文件名称需要处理
            System.out.println("文件的后缀:" + suffix);

            String uuid = UUID.randomUUID().toString();
            String newImg = uuid + suffix; //图片新名称
            System.out.println(newImg);

            //上传到数据库
            Product product = new Product(name,price,newImg);
            productService.insert(product);
            //上传图片
            String path = request.getServletContext().getRealPath("/static/img");
            String fPath = path + "/" + newImg;
            file.transferTo(new File(fPath));

        }else {
            return "redirect:/product/toAdd";
        }
        return "redirect:/product/toList";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Integer id){
        Product product = productService.getById(id);
        model.addAttribute("pro",product);
        return "edit";
    }

    @RequestMapping("/edit")
    public String edit(Product product,MultipartFile file, HttpServletRequest request) throws IOException {
        if (product.getName() != null && product.getPrice() != null && file != null) {
            String oldProductImg = file.getOriginalFilename();//获取文件(图片)名称
            String suffix = oldProductImg.substring(oldProductImg.lastIndexOf(".")); // 文件名称需要处理
            System.out.println("文件的后缀:" + suffix);

            String uuid = UUID.randomUUID().toString();
            String newImg = uuid + suffix; //图片新名称
            System.out.println(newImg);

            //上传到数据库
            Product product1 = new Product(product.getId(),product.getName(),product.getPrice(),newImg);
            productService.updateById(product1);
            //上传图片
            String path = request.getServletContext().getRealPath("/static/img");
            String fPath = path + "/" + newImg;
            file.transferTo(new File(fPath));

        }else {
            return "redirect:/product/toEdit";
        }
        return "redirect:/product/toList";
    }

    @RequestMapping("/toDel")
    public String delById(Integer id){

        productService.deleteById(id);
        return "redirect:/product/toList";
    }

}
