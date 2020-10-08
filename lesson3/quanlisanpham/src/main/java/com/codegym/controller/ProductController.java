package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    private IProductService productService = new ProductService();

    @GetMapping("/product")
    public String view(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("products",productList);
        return "index";
    }
    @GetMapping("/form/create")
    public String add( Model model){
        model.addAttribute("product", new Product());
        return "create";
    }
    @PostMapping()
    public String save(Product product, RedirectAttributes redirect) {
        productService.add(product);
        redirect.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/edit")
    public String formUpdate(@PathVariable int id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "Update";
    }
    @PostMapping("/product/update")
    public String update(@ModelAttribute("product") Product product){
        productService.update(product);
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/delete")
    public String delete(@PathVariable int id ){
        productService.remove(id);
        return "redirect:/product";
    }
    @GetMapping("/product/{id}/detail")
    public  String formdetail(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "detail";
    }

}
