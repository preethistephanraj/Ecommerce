/*package com.niit.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Product;
import com.niit.services.ProductService;

@Controller
public class ProductController {
	@Autowired
private ProductService productService;
	//http://localhost:8080/project1frontend/all/getproducts 
	@RequestMapping(value="/all/getproducts")
	public ModelAndView getAllProducts(){
		List<Product> products=productService.getAllProducts();
		//1st parameter - logical view name - productlist
		//2nd parameter - model attribute name - refer it in jsp page
		//3rd parameter - model [data] list of products
		// /WEB-INF/views/productlist.jsp
		return new ModelAndView("productlist","productsAttr",products);
	}
}



*/