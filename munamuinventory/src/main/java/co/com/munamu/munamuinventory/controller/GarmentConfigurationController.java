package co.com.munamu.munamuinventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.munamuinventory.businesslogic.facade.garmentconfiguration.FindAllGarmentConfigurationFacade;
import co.com.munamu.munamuinventory.businesslogic.facade.garmentconfiguration.FindGarmentConfigurationByIdsFacade;
import co.com.munamu.munamuinventory.businesslogic.facade.garmentconfiguration.impl.FindAllGarmentConfigurationFacadeImpl;
import co.com.munamu.munamuinventory.businesslogic.facade.garmentconfiguration.impl.FindGarmentConfigurationByIdsFacadeImpl;
import co.com.munamu.munamuinventory.controller.response.GeneratedResponse;
import co.com.munamu.munamuinventory.controller.response.concrete.GarmentConfigurationResponse;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.dto.CategoryDTO;
import co.com.munamu.munamuinventory.dto.GarmentConfigurationDTO;
import co.com.munamu.munamuinventory.dto.GenreDTO;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/api/v1/garmentsconfigurations")
public final class GarmentConfigurationController {
	


	@GetMapping("/dummy")
	public GarmentConfigurationDTO getDummy() {
		return GarmentConfigurationDTO.create();
	}
	
	@GetMapping("/byids")
	public ResponseEntity<GarmentConfigurationResponse> retrieveByIds(    
			@RequestParam String categoryId, 
		    @RequestParam String genreId, 
		    @RequestParam String typeGarmentId) {
		
		CategoryDTO categoryDTO = new  CategoryDTO();
		GenreDTO genreDTO = new GenreDTO();
		TypeGarmentDTO typeGarmentDTO = new TypeGarmentDTO();
		GarmentConfigurationDTO garmentConfigurationDTO = new GarmentConfigurationDTO();
		GarmentConfigurationResponse responseWithData = new GarmentConfigurationResponse();
		
		categoryDTO.setId(categoryId);
		genreDTO.setId(genreId);
		typeGarmentDTO.setId(typeGarmentId);
		garmentConfigurationDTO.setCategory(categoryDTO);
		garmentConfigurationDTO.setGenre(genreDTO);
		garmentConfigurationDTO.setTypeGarment(typeGarmentDTO);
		
		var messages = new ArrayList<String>();
		
		try {
			FindGarmentConfigurationByIdsFacade findGarmetsConfigurations = new FindGarmentConfigurationByIdsFacadeImpl();
			List<GarmentConfigurationDTO> garmentsConfigurations = findGarmetsConfigurations.execute(garmentConfigurationDTO);
			
			messages.add("La configuracion de prenda fue consultada satisfacotriamente...");
			responseWithData.setData(garmentsConfigurations);
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateSuccessResponseWithData(responseWithData));
			
		} catch (final MunamuInventoryException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateSuccessResponseWithData(responseWithData));
		}catch (final MunamuApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateFailedResponseWithData(responseWithData));
		}catch (final Exception exception) {
			messages.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo la consulta de la configuracion de la prenda...");
			responseWithData.setMessages(messages);
		}
		
		return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateFailedResponseWithData(responseWithData));

	}
	
	
	@GetMapping
	public ResponseEntity<GarmentConfigurationResponse> retrieveAll() {
		GarmentConfigurationResponse responseWithData = new GarmentConfigurationResponse();
		
		var messages = new ArrayList<String>();
		
		try {
			FindAllGarmentConfigurationFacade findGarments = new FindAllGarmentConfigurationFacadeImpl();
			List<GarmentConfigurationDTO> garment = findGarments.execute();
			
			messages.add("Las configuraciones de las prendas se consultaron de forma satisfactoria");
			responseWithData.setData(garment);
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateSuccessResponseWithData(responseWithData));
			
		} catch (final MunamuInventoryException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateSuccessResponseWithData(responseWithData));
		}catch (final MunamuApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			responseWithData.setMessages(messages);
			
			return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateFailedResponseWithData(responseWithData));
		}catch (final Exception exception) {
			messages.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo la consulta de la categoria...");
			responseWithData.setMessages(messages);
		}
		
		return ((new GeneratedResponse<GarmentConfigurationResponse>()).generateFailedResponseWithData(responseWithData));

	}
	
	
	
}
