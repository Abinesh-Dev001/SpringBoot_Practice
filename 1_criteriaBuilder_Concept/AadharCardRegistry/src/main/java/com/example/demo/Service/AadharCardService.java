package com.example.demo.Service;

import com.example.demo.Model.AadharCard;
import com.example.demo.TemplateInput.AadharCardNameInput;

import java.util.List;

public interface AadharCardService 
{
	public AadharCard save(AadharCard aadhar);
	public List<AadharCard> getAll();
}
