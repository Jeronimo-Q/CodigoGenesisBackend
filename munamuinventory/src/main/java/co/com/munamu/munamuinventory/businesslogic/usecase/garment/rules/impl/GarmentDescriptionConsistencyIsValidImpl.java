package co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.impl;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.GarmentDescriptionConsistencyIsValid;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;

public class GarmentDescriptionConsistencyIsValidImpl implements GarmentDescriptionConsistencyIsValid{

	@Override
	public void execute(final String data) {
		validateNotnull(data);
		validateLen(data);
	}
	
	private void validateLen(final String data) {
		if(!TextHelper.lenIsValid(data, 5, 100)) {
			var userMessage = "La descripción de la prenda solo puede tener entre 5 a 100 caracteres...";
			throw BusinessLogicMunamuInventoryException.create(userMessage);
		}
	}
	
	private void validateNotnull(final String data) {
		if(TextHelper.isEmpty(data)) {
			var userMessage = "El la descripción de la prenda no puede estar vacia...";
			throw BusinessLogicMunamuInventoryException.create(userMessage);
		}
	}

}
