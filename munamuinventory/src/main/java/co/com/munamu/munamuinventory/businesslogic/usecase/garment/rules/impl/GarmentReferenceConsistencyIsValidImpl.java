package co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.impl;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.GarmentReferenceConsistencyIsValid;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;

public class GarmentReferenceConsistencyIsValidImpl implements GarmentReferenceConsistencyIsValid{

	@Override
	public void execute(final String data) {
		validateNotnull(data);
		validateLen(data);
		validateFormat(data);
	}
	
	private void validateLen(final String data) {
		if(TextHelper.lenIsValid(data, 4, 6)) {
			var userMessage = "El numero de la referencia solo puede tener entre 4 a 6 caracteres...";
			throw BusinessLogicMunamuInventoryException.create(userMessage);
		}
	}
	
	private void validateFormat(final String data) {
		if(TextHelper.containOnlyNumbers(data)) {
			var userMessage = "El numero de la referencia solo puede contener numeros sin espacios...";
			throw BusinessLogicMunamuInventoryException.create(userMessage);
		}
	}
	
	private void validateNotnull(final String data) {
		if(TextHelper.isEmpty(data)) {
			var userMessage = "El numero de la referenia no puede estar vacio...";
			throw BusinessLogicMunamuInventoryException.create(userMessage);
		}
	}



}
