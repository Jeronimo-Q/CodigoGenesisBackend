package co.com.munamu.munamuinventory.crosscutting.exceptions;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.crosscutting.exceptions.enums.Layer;

public class MunamuInventoryException extends MunamuApplicationException {

	private static final long serialVersionUID = 1L;

	public MunamuInventoryException(final String userMessage, final String technicalMessage, final Exception rootException,
			final Layer layer) {
		super(userMessage, technicalMessage, rootException, layer);
	}

	public static MunamuInventoryException crear(final String userMessage, final String technicalMessage,
			final Exception rootException, final Layer layer) {
		return new MunamuInventoryException(userMessage, technicalMessage, rootException, layer);
	}

	public static MunamuInventoryException crear(final String userMessage) {
		return new MunamuInventoryException(userMessage, userMessage, new Exception(), Layer.GENERAL);
	}

	public static MunamuInventoryException crear(final String userMessage, final String technicalMessage) {
		return new MunamuInventoryException(userMessage, technicalMessage, new Exception(), Layer.GENERAL);
	}

}
