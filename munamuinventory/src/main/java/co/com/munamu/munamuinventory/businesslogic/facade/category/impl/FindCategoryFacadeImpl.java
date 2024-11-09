package co.com.munamu.munamuinventory.businesslogic.facade.category.impl;

import java.util.List;

import co.com.munamu.munamuinventory.businesslogic.adapter.dto.CategoryDTOAdapter;
import co.com.munamu.munamuinventory.businesslogic.facade.category.FindCategoryFacade;
import co.com.munamu.munamuinventory.businesslogic.usecase.category.impl.FindCategoryImpl;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.data.dao.enums.DAOSource;
import co.com.munamu.munamuinventory.dto.CategoryDTO;

public class FindCategoryFacadeImpl implements FindCategoryFacade{

	@Override
	public List<CategoryDTO> execute() {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			
			var findCategoryUseCase = new FindCategoryImpl(factory);
			
			return CategoryDTOAdapter.getCategoryDTOAdapter().adaptSource(findCategoryUseCase.execute());
			
		} catch (final MunamuInventoryException exception) {
			throw exception;
		} catch (final Exception exception) {
			factory.rollbackTransaction();
			var userMessage = "Se ha presentado un problema tratando de consultar la informacion de las categorias";
			var technicalMessage = "Se ha presentado un problema inesperado al trartar de consulatar la informacion de las categorias. Por favor revise el log de errores para tener mas detalles";
			
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,exception);
		}finally {
			factory.closeConnection();
		}
	}

}
