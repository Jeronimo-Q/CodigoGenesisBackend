package co.com.munamu.munamuinventory.businesslogic.facade.garmentconfiguration.impl;

import java.util.List;

import co.com.munamu.munamuinventory.businesslogic.adapter.dto.GarmentConfigurationDTOAdapter;
import co.com.munamu.munamuinventory.businesslogic.facade.garmentconfiguration.FindGarmentConfigurationFacade;
import co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.impl.FindGarmentConfigurationImpl;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.crosscutting.exceptions.MunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.data.dao.enums.DAOSource;
import co.com.munamu.munamuinventory.dto.GarmentConfigurationDTO;

public class FindGarmentConfigurationFacadeImpl implements FindGarmentConfigurationFacade {


	@Override
	public List<GarmentConfigurationDTO> execute(GarmentConfigurationDTO data) {
		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);
		
		try {
			
			var findGarmentConfigurationUseCase = new FindGarmentConfigurationImpl(factory);
			var garmentConfigurationDomain = GarmentConfigurationDTOAdapter.getGarmentConfigurationDTOAdapter().adaptTarjet(data);
			
			return GarmentConfigurationDTOAdapter.getGarmentConfigurationDTOAdapter().adaptSource(findGarmentConfigurationUseCase.execute(garmentConfigurationDomain));
			
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
