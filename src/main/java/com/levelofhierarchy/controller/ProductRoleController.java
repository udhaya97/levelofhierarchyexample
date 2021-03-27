package com.levelofhierarchy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.levelofhierarchy.model.Product;
import com.levelofhierarchy.model.ProductRoles;
import com.levelofhierarchy.model.Roles;
import com.levelofhierarchy.servicce.ProductRoleService;
import com.levelofhierarchy.servicce.ProductService;
import com.levelofhierarchy.servicce.RoleService;

@RestController
public class ProductRoleController {
	
	@Autowired
	private ProductRoleService prodRoleService;
	
	@Autowired
	private ProductService prodService;
	
	@Autowired
	private RoleService roleServ;
	/*
	 * @GetMapping("/product") public String getVal() { return
	 * prodRoleService.getAllProdRoles().get(0).getStatus(); }
	 */

	/*
	 * @GetMapping("/hai") public String getValue() { return "Hai Udhay"; }
	 */
	
	@GetMapping("/product/{prodId}/{roleId}")
	public ResponseEntity<?> getValuebByid(@PathVariable("prodId") int prodId,@PathVariable("roleId") int roleId )
	{
		try {
		ProductRoles prodRo =prodRoleService.getProdRoleById(prodId, roleId);
		return new ResponseEntity<>(prodRo.getStatus(), HttpStatus.OK);
		}catch(Exception ex)
		{
			return new ResponseEntity<>("some thing went wrong",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/product/{prodId}/{roleId}")
	public ResponseEntity<?> saveProdRole(@RequestBody ProductRoles prodRol,@PathVariable("prodId") int prodId,@PathVariable("roleId") int roleId)
	{
		try {
		Product prod = new Product();
		Roles roles = new Roles();
		prod.setProdId(prodId);
		roles.setRoleId(roleId);
		prodRol.setProduct(prod);
		prodRol.setRoles(roles);
		prodRoleService.save(prodRol);
		}catch(NullPointerException ne)
		{
			return new ResponseEntity<>("enter the values", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("data saved successfully", HttpStatus.OK);
	}
	
	@PostMapping("/product")
	public String saveProd(@RequestBody Product prod)
	{
		String get = prodService.save(prod);
		
		return get;
	}
	@PostMapping("/roles")
	public String saveRole(@RequestBody Roles roles)
	{
		String get =roleServ.save(roles);
		
		return get;
	}
}
