package com.levelofhierarchy.servicce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levelofhierarchy.model.Product;
import com.levelofhierarchy.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepo;
	@Override
	public String save(Product product) {
		
		productRepo.save(product);
		return "data saved successfully";
	}

}
