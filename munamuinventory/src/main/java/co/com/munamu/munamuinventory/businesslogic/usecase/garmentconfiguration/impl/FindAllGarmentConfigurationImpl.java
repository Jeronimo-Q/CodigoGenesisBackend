package co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.impl;

import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.entity.GarmentConfigurationEntityAdapter;
import co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.FindAllGarmentConfiguration;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;


public final class FindAllGarmentConfigurationImpl implements FindAllGarmentConfiguration{
	
	private DAOFactory daoFactory;
	
	public FindAllGarmentConfigurationImpl(DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}

	@Override
	public List<GarmentConfigurationDomain> execute() {
		
		var result = daoFactory.getGarmentConfigurationDAO().findAll();	
		
		return GarmentConfigurationEntityAdapter.getGarmentConfigurationEntityAdapter().adaptTarjet(result);
	}

	public void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la busqueda de las configuraciones prendas esperada. Por favor intente de nuevo y si el problema persiste, llame a los tecnicos";
			var technicalMessage = "El dao factory requerido para buscar la clase que busca la configuracion de la prenda llego nula.";
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,new Exception());
		}
		this.daoFactory = daoFactory;
	}


}
