package co.com.munamu.munamuinventory.crosscutting.exceptions;

import co.com.munamu.crosscutting.exceptions.enums.Layer;

public class EntityMunamuInventoryException extends MunamuInventoryException {

	private static final long serialVersionUID = 1L;

	public EntityMunamuInventoryException(final String userMessage, final String technicalMessage, final Exception rootException) {
		super(userMessage, technicalMessage, rootException, Layer.ENTITY);
	}

	public static final EntityMunamuInventoryException create(final String userMessage, final String technicalMessage,
			final Exception rootException) {
		return new EntityMunamuInventoryException(userMessage, technicalMessage, rootException);
	}

	public static final EntityMunamuInventoryException create(final String userMessage) {
		return new EntityMunamuInventoryException(userMessage, userMessage, new Exception());
	}

	public static final EntityMunamuInventoryException create(final String userMessage, final String technicalMessage) {
		return new EntityMunamuInventoryException(userMessage, technicalMessage, new Exception());
	}

}
