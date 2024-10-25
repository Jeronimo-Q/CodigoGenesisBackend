package co.com.munamu.munamuinventory.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentDTO extends DomainDTO{
	
	private String reference;
	private String description;
	private GarmentConfigurationDTO garmentConfiguration;
	
	public GarmentDTO() {
		super(UUIDHelper.getDefaultAssString());
		setGarmentConfiguration(GarmentConfigurationDTO.create());
		setDescription(TextHelper.EMPTY);
		setReference(TextHelper.EMPTY);
	}
	
	public static final GarmentDTO create() {
		return new GarmentDTO();
	}	

	public String getReference() {
		return reference;
	}

	public GarmentDTO setReference(final String reference) {
		this.reference = TextHelper.applyTrim(reference);
		return this;
	}

	public String getDescription() {
		return description;
	}

	public GarmentDTO setDescription(final String description) {
		this.description = TextHelper.applyTrim(description);
		return this;
	}

	public GarmentConfigurationDTO getGarmentConfiguration() {
		return garmentConfiguration;
	}

	public GarmentDTO setGarmentConfiguration(final GarmentConfigurationDTO garmentConfiguration) {
		this.garmentConfiguration = ObjectHelper.getDefault(garmentConfiguration, GarmentConfigurationDTO.create());
		return this;
	}

	public GarmentDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public  String getId() {
		return super.getId();
	}
	
}
