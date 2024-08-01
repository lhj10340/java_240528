package db.shopping.controller;

import java.util.Scanner;

import db.shopping.service.ProductService;
import db.shopping.service.ProductServiceImp;

public class ProductController {
	
	private Scanner scan;
	private ProductService productservice = new ProductServiceImp();
	
	public ProductController(Scanner scan) {
		this.scan = scan;
	}
	
}
