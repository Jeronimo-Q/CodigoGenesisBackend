package co.com.munamu.munamuinventory.crosscutting.exceptions;

import co.com.munamu.crosscutting.exceptions.enums.Layer;

public class DataMunamuInventoryException extends MunamuInventoryException {

	private static final long serialVersionUID = 1L;

	public DataMunamuInventoryException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.DATA);
	}

	public static final DataMunamuInventoryException crear(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new DataMunamuInventoryException(userMessage, technicalMessage, rootException);
	}

	public static final DataMunamuInventoryException crear(final String userMessage) {
		return new DataMunamuInventoryException(userMessage, userMessage, new Exception());
	}

	public static final DataMunamuInventoryException crear(final String userMessage, final String technicalMessage) {
		return new DataMunamuInventoryException(userMessage, technicalMessage, new Exception());
	}

}
