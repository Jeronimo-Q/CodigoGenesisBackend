package co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.impl;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.entity.GarmentConfigurationEntityAdapter;
import co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.RegisterNewGarmentConfiguration;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;

public final class RegisterNewGarmentConfigurationImpl implements RegisterNewGarmentConfiguration{

	private DAOFactory daoFactory;
	
	public RegisterNewGarmentConfigurationImpl(DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}
	
	@Override
	public void execute(final GarmentConfigurationDomain data) {
		//Validar las politicas
		
		
		var garmentConfigurationEntity = GarmentConfigurationEntityAdapter.getGarmentConfigurationEntityAdapter().adaptSource(data);
		daoFactory.getGarmentConfigurationDAO().create(garmentConfigurationEntity);
		
	}

	public void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo el registro de la nueva configuración de la prenda deseada. Por favor intente de nuevo y si el problema persiste, llame a los tecnicos";
			var technicalMessage = "El dao factory requerido para crear la clase que crea la configuracion de la prenda llego nula.";
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,new Exception());
		}
		this.daoFactory = daoFactory;
	}

	
	
}
