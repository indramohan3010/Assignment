package com.austin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "Amount_Interest")
public class FynarfinEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer sno;
	private long outstandingPrinciple;
	private Integer rate;
	private Integer numberOfDays;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	private Date date;
	private double calculatedInterest;
	private double outstandingInterest;
	private double totalBalance;
	private Integer payment;
	private double outstandingInterestAfterPayment;
	private double outstandingprincipleAfterPayment;
	private double totalOutstandingAferPayment;

}
