package co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.rules.impl;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.rules.GarmentConfigurationExist;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.entity.GarmentConfigurationEntity;

public final class GarmentConfigurationExistImpl implements GarmentConfigurationExist{

	@Override
	public final void execute(final UUID data,final DAOFactory factory) {
		
		var garmentConfiguration = ObjectHelper.getDefault(factory.getGarmentConfigurationDAO().findByID(data), new GarmentConfigurationEntity());
		
		
		if(data.compareTo(garmentConfiguration.getId()) != 0) {
			var userMessage = "No existe una configuracion de la prenda con el identificador "+data.toString();
			throw BusinessLogicMunamuInventoryException.create(userMessage);
		}
		
	}

}
