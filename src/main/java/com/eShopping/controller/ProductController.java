package com.eShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eShopping.DAO.ProductDAO;
import com.eShopping.entity.ProductDetails;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProductController {

	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/addproducts")
	public String addProductsPage() {
		return "AddProducts";

	}

	@RequestMapping("/productdetails")
	public String productDetails(ProductDetails productDetails) {
		System.out.println(productDetails);
		System.out.println(productDAO.getClass());
		productDAO.insertProductDetails(productDetails);
		return "redirect:/addproducts";
	}
	@RequestMapping("/getid")
	public String getProductId(int productid, Model model,HttpServletRequest request) {
		ProductDetails productById = productDAO.getProductById(productid);
		HttpSession session = request.getSession();
		session.setAttribute("productobject",productById);
		model.addAttribute("byid", productById);
		return "UpdateProducts";
	}
	
	@RequestMapping("/updateproduct")
	public String updateProducts(int quantity,HttpServletRequest request,Model model) {
		HttpSession session = request.getSession();
		ProductDetails productDetails =  (ProductDetails) session.getAttribute("productobject");
		 int totalquantity = productDetails.getQuantity()+quantity;
		productDetails.setQuantity(totalquantity);
		ProductDetails updateProducts = productDAO.updateProducts(productDetails);
		if (productDetails.getQuantity()==updateProducts.getQuantity()) {
			
			return "redirect:/searchproducts";
		} else {
			
			
			return "redirect:/searchproducts";
			
		}
	}
	@RequestMapping("/searchproducts")
	public String searchProductsPage(Model model) {
		List<ProductDetails> allProductDetails = productDAO.allProductDetails();
		model.addAttribute("allproducts", allProductDetails);
		return "AllProductDetails";
	}
	
	@RequestMapping("/deletebyid")
	public String getIdForDeleteProduct(int productid) {
          boolean byId = productDAO.deleteProductById(productid);
          if (byId) {
        	 return "redirect:/searchproducts";
		} else {
              return "redirect:/searchproducts";
		}
	}
	
	@RequestMapping("/filterProduct")
	public String filterProduct(String filterdetails,Model model) {
		List<ProductDetails> products = productDAO.filterProducts(filterdetails);
		model.addAttribute("allproducts", products);
        return "AllProductDetails";
	}
	

}
