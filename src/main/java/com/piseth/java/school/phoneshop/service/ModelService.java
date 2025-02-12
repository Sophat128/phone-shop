package com.piseth.java.school.phoneshop.service;

import java.util.List;
import java.util.Map;

import com.piseth.java.school.phoneshop.dto.ModelDTO;
import com.piseth.java.school.phoneshop.model.Model;
import org.springframework.data.domain.Page;

public interface ModelService {
	Model save(ModelDTO dto);
	Model getById(Integer id);
//	List<Model> getModels(Map<String, String> params);
	Page<Model> getModels(Map<String, String> params);
}
