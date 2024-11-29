package com.example.demo.FilterRepositoryIMPL;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.FilterInput.AadharCardSearchFilter;
import com.example.demo.FilterRepository.AadharCustomRepo;
import com.example.demo.Model.AadharCard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;


public class AadharCustomRepoImpl implements AadharCustomRepo 
{
	@Autowired
	public EntityManager em;

	public List<AadharCard> getAadharDetails(List<String> name, List<String> email) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<AadharCard> cq = cb.createQuery(AadharCard.class);
        
        Root<AadharCard> aadhar= cq.from(AadharCard.class);
        
        List<Predicate> predicates = new ArrayList<>();
        Predicate namePredicate=null;
        Predicate emailPredicate=null;
        
        if(name==null)
        {
        	
        }else if(name.size()>0)
        {
        	System.out.println("hi");
        	Expression<String> parentExpression=aadhar.get("name");
        	namePredicate=parentExpression.in(name);
//        	Predicate nameP=cb.like(aadhar.get("name"), "%"+name+"%");
//        	predicates.add(nameP);
        	predicates.add(namePredicate);
        }
        
        if(email==null)
        {
        	
        }else if(email.size()>0)
        {
        	Expression<String> parentExpression=aadhar.get("email");
        	emailPredicate=parentExpression.in(email);
        	predicates.add(emailPredicate);
        }
        
        if (!predicates.isEmpty()) {
            cq.where(predicates.toArray(new Predicate[0]));
        }
        
        //cq.where(predicates.toArray(new Predicate[0]));
        TypedQuery<AadharCard> query = em.createQuery(cq);
        
        System.out.println("Query :"+query.getResultList());
        
		return query.getResultList();
	}

	
	

	

}
