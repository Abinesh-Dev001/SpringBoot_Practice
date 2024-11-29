package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.FilterInput.AadharCardSearchFilter;
import com.example.demo.FilterRepositoryIMPL.AadharCustomRepoImpl;
import com.example.demo.Model.AadharCard;
import com.example.demo.ServiceImplementation.AadharCardServiceImpl;
import com.example.demo.TemplateInput.AadharCardNameInput;

@RestController
@RequestMapping("/api/reg")
public class AadharController 
{
	@Autowired
	public AadharCardServiceImpl aadharService;
	
	@Autowired
	public AadharCustomRepoImpl repo;
	
	@PostMapping("save")
	public AadharCard saveMethod(@RequestBody AadharCard aadhar)
	{
		return aadharService.save(aadhar);
	}
	
	@GetMapping("list")
	public List<AadharCard> getAllMethod()
	{
		return aadharService.getAll();
	}
	
	@PostMapping("filter")
	public List<AadharCard> filter(@RequestBody AadharCardSearchFilter filter)
	{
		List<AadharCard> filters=repo.getAadharDetails(filter.getName(), filter.getEmail());
		return filters;
	}
}
