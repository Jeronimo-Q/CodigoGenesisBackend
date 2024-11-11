package co.com.munamu.munamuinventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.munamuinventory.businesslogic.facade.garment.impl.RegisterNewGarmentFacadeImpl;
import co.com.munamu.munamuinventory.controller.response.GeneratedResponse;
import co.com.munamu.munamuinventory.controller.response.concrete.GenericResponse;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.dto.GarmentDTO;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/api/v1/garments")
public final class GarmentController {
	


	@GetMapping("/dummy")
	public GarmentDTO getDummy() {
		return GarmentDTO.create();
	}
	

	@PostMapping
	public ResponseEntity<GenericResponse> create(@RequestBody GarmentDTO garment) {
		var message = new ArrayList<String>();
		
		try {
			var registerNewGarmentFacade = new RegisterNewGarmentFacadeImpl();
			registerNewGarmentFacade.execute(garment);
			message.add("La prenda se registro de forma satisfactoria");
			
			return GeneratedResponse.generateSuccessResponse(message);
		} catch (final MunamuInventoryException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GeneratedResponse.generateSuccessResponse(message);
		}catch (final MunamuApplicationException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return GeneratedResponse.generateFailedResponse(message);
		}catch (final Exception exception) {
			message.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo el registro de la nueva prenda...");
		}
		
		message.add("La prenda se agrego de forma satisfactoria");
		
		return GeneratedResponse.generateFailedResponse(message);
		
		
		
	}
	
	
}
