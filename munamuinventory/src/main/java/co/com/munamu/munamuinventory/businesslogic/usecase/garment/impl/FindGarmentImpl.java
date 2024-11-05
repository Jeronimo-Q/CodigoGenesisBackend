package co.com.munamu.munamuinventory.businesslogic.usecase.garment.impl;

import java.util.List;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.entity.GarmentEntityAdapter;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.FindGarmentConfiguration;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.GarmentDomain;


public final class FindGarmentImpl implements FindGarmentConfiguration{
	
	private DAOFactory daoFactory;
	
	public FindGarmentImpl(DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}

	@Override
	public List<GarmentDomain> execute(final GarmentDomain data) {
		
		var garmentEntity = GarmentEntityAdapter.getGarmentEntityAdapter().adaptSource(data);
		var result = daoFactory.getGarmentDAO().findByFilter(garmentEntity);	
		
		return GarmentEntityAdapter.getGarmentEntityAdapter().adaptTarjet(result);
	}

	public void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la busqueda de la configuración de la prenda deseada. Por favor intente de nuevo y si el problema persiste, llame a los tecnicos";
			var technicalMessage = "El dao factory requerido para buscar la clase que busca la configuracion de la prenda llego nula.";
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,new Exception());
		}
		this.daoFactory = daoFactory;
	}
}
