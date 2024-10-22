package co.com.munamu.munamuinventory.crosscutting.exceptions;

import co.com.munamu.crosscutting.exceptions.enums.Layer;

public class DTOMunamuInventoryException extends MunamuInventoryException {

	private static final long serialVersionUID = 1L;

	public DTOMunamuInventoryException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DTO);
	}

	public static final DTOMunamuInventoryException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DTOMunamuInventoryException(userMessage, technicalMessage, rootException);
	}

	public static final DTOMunamuInventoryException create(final String userMessage) {
		return new DTOMunamuInventoryException(userMessage, userMessage, new Exception());
	}

	public static final DTOMunamuInventoryException create(final String userMessage, final String technicalMessage) {
		return new DTOMunamuInventoryException(userMessage, technicalMessage, new Exception());
	}

}
