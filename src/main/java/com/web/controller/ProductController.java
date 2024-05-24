package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.web.entities.Product;
import com.web.service.ProductService;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
	@Autowired
	
private ProductService service;
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	@GetMapping("/products")
	public List<Product> findAllProducts()
	{
		return service.getProducts();
	}
	@GetMapping("/product/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getById(id);
	}
	 @PutMapping("/product/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id); 
        return service.updateProduct(product);
    }
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id)
	{
		String msg= "";
		try {
			msg=  service.deleteProduct(id);
			return ResponseEntity.ok().body(msg);
		} catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"Failed to delete product\", \"productId\": " + id + "}");

		}
		
		
	}
}
