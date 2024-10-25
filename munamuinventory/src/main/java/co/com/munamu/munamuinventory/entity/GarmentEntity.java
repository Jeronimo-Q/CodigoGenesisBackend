package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentEntity extends DomainEntity{
	
	private String reference;
	private String description;
	private GarmentConfigurationEntity garmentConfiguration;
	
	public GarmentEntity() {
		super(UUIDHelper.getDefault());
		setGarmentConfiguration(GarmentConfigurationEntity.create());
		setDescription(TextHelper.EMPTY);
		setReference(TextHelper.EMPTY);
	}
	
	public static final GarmentEntity create() {
		return new GarmentEntity();
	}	

	public String getReference() {
		return reference;
	}

	public GarmentEntity setReference(final String reference) {
		this.reference = TextHelper.applyTrim(reference);
		return this;
	}

	public String getDescription() {
		return description;
	}

	public GarmentEntity setDescription(final String description) {
		this.description = TextHelper.applyTrim(description);
		return this;
	}

	public GarmentConfigurationEntity getGarmentConfiguration() {
		return garmentConfiguration;
	}

	public GarmentEntity setGarmentConfiguration(final GarmentConfigurationEntity garmentConfiguration) {
		this.garmentConfiguration = ObjectHelper.getDefault(garmentConfiguration, GarmentConfigurationEntity.create());
		return this;
	}

	@Override
	public void setId(final UUID id) {
		super.setId(id);
	
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
