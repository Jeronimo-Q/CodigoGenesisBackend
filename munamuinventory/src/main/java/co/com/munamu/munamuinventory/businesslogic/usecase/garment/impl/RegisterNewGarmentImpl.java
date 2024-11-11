package co.com.munamu.munamuinventory.businesslogic.usecase.garment.impl;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.entity.GarmentEntityAdapter;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.RegisterNewGarment;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.GarmentDescriptionDoesNotExist;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.GarmentReferenceConsistencyIsValid;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.GarmentReferenceDoesNotExist;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.impl.GarmentDescriptionDoesNotExistImpl;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.impl.GarmentReferenceConsistencyIsValidImpl;
import co.com.munamu.munamuinventory.businesslogic.usecase.garment.rules.impl.GarmentReferenceDoesNotExistImpl;
import co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.rules.GarmentConfigurationExist;
import co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration.rules.impl.GarmentConfigurationExistImpl;
import co.com.munamu.munamuinventory.crosscutting.exceptions.BusinessLogicMunamuInventoryException;
import co.com.munamu.munamuinventory.data.dao.DAOFactory;
import co.com.munamu.munamuinventory.domain.GarmentDomain;

public final class RegisterNewGarmentImpl implements RegisterNewGarment{

	private DAOFactory daoFactory;
	private GarmentReferenceDoesNotExist garmentReferenceDoesNotExistImpl = new GarmentReferenceDoesNotExistImpl();
	private GarmentConfigurationExist garmentConfigurationExistImpl = new GarmentConfigurationExistImpl();
	private GarmentReferenceConsistencyIsValid garmentReferenceConsistencyIsValidImpl = new GarmentReferenceConsistencyIsValidImpl(); 
	private GarmentDescriptionDoesNotExist garmentDescriptionDoesNotExistImpl = new GarmentDescriptionDoesNotExistImpl();
	
	
	public RegisterNewGarmentImpl( final DAOFactory daoFactory){
		setDaoFactory(daoFactory);
	}
	
	@Override
	public void execute(final GarmentDomain data) {
		
		garmentReferenceConsistencyIsValidImpl.execute(data.getReference());
		garmentReferenceDoesNotExistImpl.execute(data, daoFactory);
		garmentDescriptionDoesNotExistImpl.execute(data, daoFactory);
		garmentConfigurationExistImpl.execute(data.getGarmentConfiguration().getId(), daoFactory);
		
		var garmentDomainToMap = GarmentDomain.create(generatedId(), data.getGarmentConfiguration(), data.getDescription(), data.getReference());
		var garmentEntity = GarmentEntityAdapter.getGarmentEntityAdapter().adaptSource(garmentDomainToMap);
		daoFactory.getGarmentDAO().create(garmentEntity);
		
	}

	public void setDaoFactory(final DAOFactory daoFactory) {
		if(ObjectHelper.isNull(daoFactory)) {
			var userMessage = "Se ha presentado un problema inesperado tratando de llevar a cabo el registro de la nueva prenda deseada. Por favor intente de nuevo y si el problema persiste, llame a los tecnicos";
			var technicalMessage = "El dao factory requerido para crear la clase que crea la prenda llego nula.";
			throw BusinessLogicMunamuInventoryException.create(userMessage,technicalMessage,new Exception());
		}
		this.daoFactory = daoFactory;
	}

	private UUID generatedId() {
		var id = UUIDHelper.generate();
		var stateEntity = daoFactory.getGarmentDAO().findByID(id);
		
		if(UUIDHelper.isEqual(stateEntity.getId(), id)) {
			id = generatedId();
		}
		
		return id;
	}
	
	
}
