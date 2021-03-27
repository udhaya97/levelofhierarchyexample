package com.levelofhierarchy.servicce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.levelofhierarchy.model.Roles;
import com.levelofhierarchy.repository.RolesRepository;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RolesRepository roleRepo;
	
	@Override
	public String save(Roles roles) {
		// TODO Auto-generated method stub
		roleRepo.save(roles);
		return "data save successfully";
	}

}
