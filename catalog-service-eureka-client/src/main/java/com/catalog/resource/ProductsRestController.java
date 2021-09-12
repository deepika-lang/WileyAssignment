package com.catalog.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.catalog.bean.ProductList;
import com.catalog.bean.Products;
import com.catalog.service.ProductsService;

@RestController
@RequestMapping("/products")
public class ProductsRestController {

	@Autowired
	ProductsService productService;
	
	
//	  @GetMapping(produces="Application/json") 
//	  public List<Products> getAllRecords(){ 
//		  return productService.getAllProducts(); 
//	
//	  }
	 
	
	@GetMapping(produces="Application/json")
	public ResponseEntity<ProductList> getAllRecords(){
		try {
			productService.getAllProducts();
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
	}
	
//	@GetMapping(path="/{code}",produces="Application/json")
//	public Optional<Products> getProductByCode(@PathVariable("code") String code){
//		return productService.getProductByCode(code);
//	}
	@GetMapping(path="/{code}",produces="Application/json")
	public ResponseEntity<Optional<Products>> getProductByCode(@PathVariable("code")String code){
		try {
			productService.getProductByCode(code);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
			return ResponseEntity.status(HttpStatus.OK).body(productService.getProductByCode(code));
			
	}
	@GetMapping(path="/productprice/{code}",produces="Application/json")
	public ResponseEntity<Double> getProductPriceByCode(@PathVariable("code")String code){
		try {
			productService.getProductPriceByProductCode(code);
		}
		catch(Exception ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(productService.getProductPriceByProductCode(code));
	}
}
