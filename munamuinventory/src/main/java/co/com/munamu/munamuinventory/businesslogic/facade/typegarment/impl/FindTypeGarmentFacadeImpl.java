package co.com.munamu.munamuinventory.businesslogic.facade.typegarment.impl;

import java.util.List;

import co.com.munamu.munamuinventory.businesslogic.adapter.dto.TypeGarmentDTOAdapter;
import co.com.munamu.munamuinventory.businesslogic.facade.typegarment.FindTypeGarmentFacade;
import co.com.munamu.munamuinventory.businesslogic.usecase.typegarment.impl.FindTypeGarmentImpl;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.data.dao.enums.DAOSource;
import co.com.munamu.munamuinventory.dto.TypeGarmentDTO;

public class FindTypeGarmentFacadeImpl implements FindTypeGarmentFacade{

	@Override
	public List<TypeGarmentDTO> execute() {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			
			var findTypeGarmentUseCase = new FindTypeGarmentImpl(factory);
			
			return TypeGarmentDTOAdapter.getTypeGarmentDTOAdapter().adaptSource(findTypeGarmentUseCase.execute());
			
		} catch (final MunamuInventoryException exception) {
			throw exception;
		} catch (final Exception exception) {
			factory.rollbackTransaction();
			var userMessage = "Se ha presentado un problema tratando de consultar la informacion de los tipo de prendas...";
			var technicalMessage = "Se ha presentado un problema inesperado al trartar de consultar la informacion de los tipos de prenda. Por favor revise el log de errores para tener mas detalles";
			
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,exception);
		}finally {
			factory.closeConnection();
		}
	}

}
