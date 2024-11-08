package co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.impl;

import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.GarmentDescriptionDoesNotExist;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.GarmentDomain;
import co.com.munamu.munamuinventory.entity.GarmentEntity;

public class GarmentDescriptionDoesNotExistImpl implements GarmentDescriptionDoesNotExist{

	@Override
	public void execute(final GarmentDomain data,final DAOFactory factory) {
		final var garment = new GarmentEntity();

		garment.setDescription(data.getReference());
		
		var results = factory.getGarmentDAO().findByFilter(garment);
		
		if(results.isEmpty()) {
			var userMessage = "Ya existe una prenda con la referencia "+results.get(0).getDescription()+" ...";
			throw BusinessLogicMunamuInventoryException.create(userMessage);
		}
		
	}

}
