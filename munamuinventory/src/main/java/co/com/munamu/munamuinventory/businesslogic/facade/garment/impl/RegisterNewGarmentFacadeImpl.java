package co.com.munamu.munamuinventory.businesslogic.facade.garment.impl;

import co.com.munamu.crosscutting.exceptions.MunamuApplicationException;
import co.com.munamu.munamuinventory.businesslogic.adapter.dto.GarmentDTOAdapter;
import co.com.munamu.munamuinventory.businesslogic.facade.garment.RegisterNewGarmentFacade;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.impl.RegisterNewGarmentImpl;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.data.dao.enums.DAOSource;
import co.com.munamu.munamuinventory.dto.GarmentDTO;

public final class RegisterNewGarmentFacadeImpl implements RegisterNewGarmentFacade {

	@Override
	public void execute(final GarmentDTO data) {

		var factory = DAOFactory.getFactory(DAOSource.SQLSERVER);

		try {
			factory.initTransaction();

			var registerNewGarmentUseCase = new RegisterNewGarmentImpl(factory);

			var garmentDomain = GarmentDTOAdapter.getGarmentDTOAdapter().adaptTarjet(data);

			registerNewGarmentUseCase.execute(garmentDomain);
			factory.commitTransaction();
		} catch (final MunamuApplicationException exception) {
			factory.rollbackTransaction();

			throw exception;
		} catch (final Exception exception) {

			factory.rollbackTransaction();

			var userMessages = "Se ha presentado un problema tratando registrar la informacion de la nueva prenda...";

			var technicalMessage = "Se ha presentado un problema inesperado registrando la informacion de la nueva prenda. Por favor revise el log de errores para tener más detalles...";

			throw BusinessLogicMunamuInventoryException.create(userMessages, technicalMessage, exception);
		} finally {
			factory.closeConnection();
		}

	}
}
