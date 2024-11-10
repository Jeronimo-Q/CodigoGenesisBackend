package co.com.munamu.munamuinventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.munamuinventory.businesslogic.facade.genre.FindGenreFacade;
import co.com.munamu.munamuinventory.businesslogic.facade.genre.impl.FindGenreFacadeImpl;
import co.com.munamu.munamuinventory.controller.response.GeneratedResponse;
import co.com.munamu.munamuinventory.controller.response.concrete.GenreResponse;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.dto.GenreDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/api/v1/genres")
public final class GenreController {
	


	@GetMapping("/dummy")
	public GenreDTO getDummy() {
		return GenreDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<GenreResponse> retrieveAll() {
		GenreResponse responseWithData = new GenreResponse();
		
		var messages = new ArrayList<String>();
		
		try {
			FindGenreFacade findGenre = new FindGenreFacadeImpl();
			List<GenreDTO> genres = findGenre.execute();
			
			messages.add("El genero se consulto de forma satisfactoria");
			responseWithData.setData(genres);
			responseWithData.setMessages(messages);
		
			
			return ((new GeneratedResponse<GenreResponse>()).generateSuccessResponseWithData(responseWithData));
			
		} catch (final MunamuInventoryException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			
			return ((new GeneratedResponse<GenreResponse>()).generateSuccessResponseWithData(responseWithData));
		}catch (final MunamuApplicationException exception) {
			messages.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return ((new GeneratedResponse<GenreResponse>()).generateFailedResponseWithData(responseWithData));
		}catch (final Exception exception) {
			messages.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo de la consulta de los generos...");
		}
		
		messages.add("Los generos se consultaron de forma satisfactoria...");
		
		return ((new GeneratedResponse<GenreResponse>()).generateFailedResponseWithData(responseWithData));

	}
	
	
}
