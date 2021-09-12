package com.retail.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.retail.bean.Customer;
import com.retail.bean.OrderItem;
import com.retail.bean.OrderT;
import com.retail.bean.Products;
import com.retail.model.service.CustomerService;
import com.retail.model.service.ProductService;

@Controller
@SessionAttributes({"customer"})
public class MainController {

	@Autowired
	ProductService productService;
	
	@Autowired
	CustomerService customerService;
	
	ArrayList<Products> productslist=new ArrayList<Products>();
	OrderT order=new OrderT();
	Customer globalCustomer=new Customer();
	List<OrderItem> items=new ArrayList<OrderItem>();
	
	@RequestMapping(value="/")
	public ModelAndView indexPage() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView productsController() {
		List<Products> products=productService.getAllProducts();
		return new ModelAndView("displayProducts","products",products);
	}
	
	@RequestMapping("/addToCart")
	public ModelAndView addToCart(@RequestParam("productCode") String code,@RequestParam("productQuantity")int quantity) {
	//	Products product=productService.getProductByProductCode(code, quantity);
		ModelAndView modelAndView=new ModelAndView();
		String message;
		if(productService.productAddToCart(code, quantity)==1) {
			message="Product not found!";
			modelAndView.addObject("message",message);
			modelAndView.setViewName("cartfail");
			return modelAndView;
		}
		else if(productService.productAddToCart(code, quantity)==2) {
			message="Not enough quantity in stock for product "+code;
			modelAndView.addObject("message",message);
			modelAndView.setViewName("cartfail");
			return modelAndView;
		}
		else if(productService.productAddToCart(code, quantity)==3) {
			message="Entering out of stock quantity for product "+code;
			modelAndView.addObject("message",message);
			modelAndView.setViewName("cartfail");
			return modelAndView;
		}
		else{
			int flagForSame=0;
			OrderItem o=new OrderItem(code,quantity);
			for(OrderItem i:items) {
				if(i.getProductId().equals(code)) {
					flagForSame=1;
					i.setQuantity(i.getQuantity()+quantity);
				}
			}
			if(flagForSame==0)
				items.add(o);
			return new ModelAndView("cartsuccess");
		}	
		
	}
	
	@RequestMapping("/cart")
	public ModelAndView cartController() {
		if(items.size()<1)
			return new ModelAndView("emptycart");
		return new ModelAndView("cart","items",items);
	}
	
	@RequestMapping("/checkout")
	public ModelAndView checkoutController() {
		ModelAndView modelAndView=new ModelAndView();
		order.setItems(items);
		OrderT o=productService.createOrder(order);
		double total=productService.sumGenerator(o);
		modelAndView.addObject("o",o);
		modelAndView.addObject("total",total);
		modelAndView.setViewName("checkout");
		return modelAndView;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginPageController() {
		return new ModelAndView("login","customer",new Customer());
	}
	@RequestMapping("/loginaction")
	public ModelAndView loginController(@ModelAttribute("customer")Customer customer) {
		
		ModelAndView modelAndView=new ModelAndView();
		String name=customer.getCustomerName();
		String password=customer.getCustomerPassword();
		String message=null;
		if(customerService.getCustomerByCustomerName(name, password)==true) {
			message="Login Successful";
			globalCustomer=customerService.getCustomer(name,password);
			order.setCustomerAddress(globalCustomer.getCustomerAddress());
			order.setCustomerEmail(globalCustomer.getCustomerEmail());
			modelAndView.addObject(message);
			modelAndView.setViewName("loginpass");
		}
		else
		{
			message="Log in failed";
			modelAndView.addObject(message);
			modelAndView.setViewName("loginfail");
		}
		return modelAndView;
		
	}
	
	@RequestMapping("/signup")
	public ModelAndView signupController() {
		return new ModelAndView("signup","customer",new Customer());
	}
	@RequestMapping("/save")
	public ModelAndView signup(@ModelAttribute("customer")Customer customer) {
		if(customerService.insertCustomer(customer)==true) {
			return new ModelAndView("signuppass");
		}
		else
			return new ModelAndView("signupfail");
		
	}
}
