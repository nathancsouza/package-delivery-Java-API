package com.delivery.project.deliveries;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.project.model.Delivery;
import com.delivery.project.repository.DeliveryRepository;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

	@Autowired
	private DeliveryRepository deliverieRepository;
	
	@GetMapping
	public List<Delivery> list() {
		return deliverieRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery add(@RequestBody @Valid Delivery deliverie) {
		return deliverieRepository.save(deliverie);
	}
}
