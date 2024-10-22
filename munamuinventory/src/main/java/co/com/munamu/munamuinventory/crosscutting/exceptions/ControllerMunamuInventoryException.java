package co.com.munamu.munamuinventory.crosscutting.exceptions;

import co.com.munamu.crosscutting.exceptions.enums.Layer;

public class ControllerMunamuInventoryException extends MunamuInventoryException {

	private static final long serialVersionUID = 1L;

	public ControllerMunamuInventoryException(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.CONTROLLER);
	}

	public static final ControllerMunamuInventoryException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new ControllerMunamuInventoryException(userMessage, technicalMessage, rootException);
	}

	public static final ControllerMunamuInventoryException create(final String userMessage) {
		return new ControllerMunamuInventoryException(userMessage, userMessage, new Exception());
	}

	public static final ControllerMunamuInventoryException create(final String userMessage, final String technicalMessage) {
		return new ControllerMunamuInventoryException(userMessage, technicalMessage, new Exception());
	}

}
