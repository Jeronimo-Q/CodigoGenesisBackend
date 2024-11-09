package co.com.munamu.munamuinventory.businesslogic.facade.genre.impl;

import java.util.List;

import co.com.munamu.munamuinventory.businesslogic.adapter.dto.GenreDTOAdapter;
import co.com.munamu.munamuinventory.businesslogic.facade.genre.FindGenreFacade;
import co.com.munamu.munamuinventory.businesslogic.usecase.genre.impl.FindGenreImpl;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.data.dao.enums.DAOSource;
import co.com.munamu.munamuinventory.dto.GenreDTO;

public class FindGenreFacadeImpl implements FindGenreFacade{

	@Override
	public List<GenreDTO> execute() {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			
			var findGenreUseCase = new FindGenreImpl(factory);
			
			return GenreDTOAdapter.getGenreDTOAdapter().adaptSource(findGenreUseCase.execute());
			
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
