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
			var var1 = findGenreUseCase.execute();
			return GenreDTOAdapter.getGenreDTOAdapter().adaptSource(var1);
			
		} catch (final MunamuInventoryException exception) {
			throw exception;
		} catch (final Exception exception) {
			factory.rollbackTransaction();
			var userMessage = "Se ha presentado un problema tratando de consultar la informacion de los generos";
			var technicalMessage = "Se ha presentado un problema inesperado al trartar de consulatar la informacion de los generos. Por favor revise el log de errores para tener mas detalles";
			
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,exception);
		}finally {
			factory.closeConnection();
		}
	}

}
