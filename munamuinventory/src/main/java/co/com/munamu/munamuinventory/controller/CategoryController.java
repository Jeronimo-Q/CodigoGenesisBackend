package co.com.munamu.munamuinventory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.munamuinventory.businesslogic.facade.category.FindCategoryFacade;
import co.com.munamu.munamuinventory.businesslogic.facade.category.impl.FindCategoryFacadeImpl;
import co.com.munamu.munamuinventory.controller.response.GeneratedResponse;
import co.com.munamu.munamuinventory.controller.response.concrete.CategoryResponse;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.dto.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping ("/api/v1/categories")
public final class CategoryController {
	


	@GetMapping("/dummy")
	public CategoryDTO getDummy() {
		return CategoryDTO.create();
	}
	
	@GetMapping
	public ResponseEntity<CategoryResponse> retrieveAll() {
		CategoryResponse responseWithData = new CategoryResponse();
		
		var message = new ArrayList<String>();
		
		message.add("hola");
		
		
		try {
			FindCategoryFacade findCategory = new FindCategoryFacadeImpl();
			List<CategoryDTO> categories = findCategory.execute();
			
			responseWithData.setData(categories);
			responseWithData.setMessages(message);
			
			return ((new GeneratedResponse<CategoryResponse>()).generateSuccessResponseWithData(responseWithData));
			
		} catch (final MunamuInventoryException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return ((new GeneratedResponse<CategoryResponse>()).generateSuccessResponseWithData(responseWithData));
		}catch (final MunamuApplicationException exception) {
			message.add(exception.getUserMessage());
			exception.printStackTrace();
			
			return ((new GeneratedResponse<CategoryResponse>()).generateFailedResponseWithData(responseWithData));
		}catch (final Exception exception) {
			message.add(
					"Se ha presentado un problema inesperado tratando de llevar a cabo la consulta de la categoria satisfactoria");
		}
		
		message.add("Las categorias se consultaron de forma satisfactoria");
		
		return ((new GeneratedResponse<CategoryResponse>()).generateFailedResponseWithData(responseWithData));

	}
	
	
}
