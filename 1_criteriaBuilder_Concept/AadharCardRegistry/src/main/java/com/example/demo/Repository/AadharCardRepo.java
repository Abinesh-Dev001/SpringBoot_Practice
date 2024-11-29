package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.FilterRepository.AadharCustomRepo;
import com.example.demo.Model.AadharCard;
import com.example.demo.TemplateInput.AadharCardNameInput;

@Repository
public interface AadharCardRepo extends JpaRepository<AadharCard, Integer>,AadharCustomRepo
{

	@Query(nativeQuery = true,value="select * from registry where name=(:namex)")
	AadharCard getNameDetails(@Param("name") AadharCardNameInput name);
	
	
}
