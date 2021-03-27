package com.levelofhierarchy.servicce;

import org.springframework.stereotype.Service;

import com.levelofhierarchy.model.Roles;

@Service
public interface RoleService {
	
	String save(Roles roles);

}
