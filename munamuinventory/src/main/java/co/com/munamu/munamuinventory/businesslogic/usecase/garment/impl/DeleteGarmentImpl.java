package co.com.munamu.munamuinventory.businesslogic.usecase.garment.impl;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.DeleteGarment;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;

public final class DeleteGarmentImpl implements DeleteGarment{

	private DAOFactory daoFactory;
	
	public DeleteGarmentImpl(DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}
	
	@Override
	public void execute(final UUID data) {
		//validar politicas
		
		
		daoFactory.getGarmentDAO().delete(data);
	}

	
	public void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo la eliminacion de la prenda deseada. Por favor intente de nuevo y si el problema persiste, llame a los tecnicos";
			var technicalMessage = "El dao factory requerido para eliminar la clase que elimina la prenda llego nula.";
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,new Exception());
		}
		this.daoFactory = daoFactory;
	}
}
