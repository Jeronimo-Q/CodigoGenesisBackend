package co.com.munamu.munamuinventory.crosscutting.exceptions;

import co.com.munamu.crosscutting.exceptions.enums.Layer;

public class BusinessLogicMunamuInventoryException extends MunamuInventoryException {

	private static final long serialVersionUID = 1L;

	public BusinessLogicMunamuInventoryException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.BUSINESSLOGIC);
	}

	public static final BusinessLogicMunamuInventoryException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new BusinessLogicMunamuInventoryException(userMessage, technicalMessage, rootException);
	}

	public static final BusinessLogicMunamuInventoryException crear(final String userMessage) {
		return new BusinessLogicMunamuInventoryException(userMessage, userMessage, new Exception());
	}

	public static final BusinessLogicMunamuInventoryException crear(final String userMessage, final String technicalMessage) {
		return new BusinessLogicMunamuInventoryException(userMessage, technicalMessage, new Exception());
	}

}
