package com.example.demo.ServiceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.AadharCard;
import com.example.demo.Repository.AadharCardRepo;
import com.example.demo.Service.AadharCardService;
import com.example.demo.TemplateInput.AadharCardNameInput;

@Service
public class AadharCardServiceImpl implements AadharCardService
{

	@Autowired
	public AadharCardRepo aadharRepo;
	
	@Override
	public AadharCard save(AadharCard aadhar) 
	{
		return aadharRepo.save(aadhar);
	}

	@Override
	public List<AadharCard> getAll() {
		return aadharRepo.findAll();
	}

	

}
