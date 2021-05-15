package com.austin.srvice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.austin.model.FynarfinEntity;
import com.austin.repository.FynarfinRepository;

@Service
public class FynarfinService {

	@Autowired
	private FynarfinRepository repository;

	private double interest;
	private double result;
	private double total;
	public FynarfinEntity calculateSimpleInterest(FynarfinEntity entity) {

		result= entity.getOutstandingPrinciple()*entity.getRate()*entity.getNumberOfDays();
		interest=result/36500;
		System.out.println(interest);
		entity.setCalculatedInterest(interest);
		total=entity.getOutstandingPrinciple()+entity.getCalculatedInterest();
		entity.setTotalBalance(total);

		entity.setOutstandingprincipleAfterPayment(entity.getTotalBalance()-entity.getPayment());
		entity.setTotalOutstandingAferPayment(entity.getTotalBalance()-entity.getPayment());

		FynarfinEntity save = repository.save(entity);
		return save;
	}
	public List<FynarfinEntity> getAllRecord() {
		List<FynarfinEntity> findAll = repository.findAll();
		return findAll;
	}

}
