package co.com.munamu.munamuinventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.munamuinventory.businesslogic.facade.typegarment.FindTypeGarmentFacade;
import co.com.munamu.munamuinventory.businesslogic.facade.typegarment.impl.FindTypeGarmentFacadeImpl;
import co.com.munamu.munamuinventory.controller.response.GeneratedResponse;
import co.com.munamu.munamuinventory.controller.response.concrete.TypeGarmentResponse;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/api/v1/typegarments")
public final class TypeGarmentController {
	


	@GetMapping("/dummy")
	public TypeGarmentDTO getDummy() {
		return TypeGarmentDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<TypeGarmentResponse> retrieveAll() {
		TypeGarmentResponse responseWithData = new TypeGarmentResponse();
		
		var messages = new ArrayList<String>();
		
		try {
			FindTypeGarmentFacade findTypeGarmets = new FindTypeGarmentFacadeImpl();
			List<TypeGarmentDTO> typeGarments = findTypeGarmets.execute();
			
			messages.add("Los tipos de prendas se consultaron de forma satisfactoria");
			responseWithData.setData(typeGarments);
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<TypeGarmentResponse>()).generateSuccessResponseWithData(responseWithData));
			
		} catch (final MunamuInventoryException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<TypeGarmentResponse>()).generateSuccessResponseWithData(responseWithData));
		}catch (final MunamuApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<TypeGarmentResponse>()).generateFailedResponseWithData(responseWithData));
		}catch (final Exception exception) {
			messages.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo la consulta de los tipo de prenda...");
			responseWithData.setMessages(messages);
		}
		
		return ((new GeneratedResponse<TypeGarmentResponse>()).generateFailedResponseWithData(responseWithData));

	}
	
	
}
