package co.com.munamu.munamuinventory.businesslogic.usecase.garment.impl;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.entity.GarmentEntityAdapter;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.RegisterNewGarment;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.GarmentDomain;

public final class RegisterNewGarmentImpl implements RegisterNewGarment{

	private DAOFactory daoFactory;
	
	public RegisterNewGarmentImpl( DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}
	
	@Override
	public void execute(final GarmentDomain data) {
		//Validar las politicas
		
		
		var garmentEntity = GarmentEntityAdapter.getGarmentEntityAdapter().adaptSource(data);
		daoFactory.getGarmentDAO().create(garmentEntity);
		
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
