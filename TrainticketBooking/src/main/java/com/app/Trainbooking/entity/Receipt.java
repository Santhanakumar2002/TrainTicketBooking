package com.app.Trainbooking.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "tb_train_receipt")
public class Receipt {
	 @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	    @Type(type = "uuid-char")
	    @Column(name = "id", updatable = false, nullable = false)
	    private UUID id;

	    @Column(name = "from_column")
	    private String from;

	    @Column(name = "to_column")
	    private String to;

	    @Column(name = "price_paid")
	    private Double pricePaid;

	    @JsonManagedReference
	    @OneToMany(mappedBy = "receipt",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<User> users;
	    

	

}
