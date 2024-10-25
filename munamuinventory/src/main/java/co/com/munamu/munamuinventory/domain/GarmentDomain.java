package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;


public class GarmentDomain extends Domain{
	
	private String reference;
	private String description;
	private GarmentConfigurationDomain garmentConfiguration;
	
	private GarmentDomain(final UUID id, final GarmentConfigurationDomain garmentConfiguration,final String description,final String reference) {
		super (id);
		setGarmentConfiguration(garmentConfiguration);
		setDescription(description);
		setReference(reference);
		
	}
	
	public static GarmentDomain create(final UUID id, final GarmentConfigurationDomain garmentConfiguration,final String description,final String reference) {
		return new GarmentDomain(id, garmentConfiguration, description, reference);
	}
	
	static final GarmentDomain create() {
		return new GarmentDomain(UUIDHelper.getDefault(), GarmentConfigurationDomain.create(), TextHelper.EMPTY,TextHelper.EMPTY);
	}
	
	public String getReference() {
		return reference;
	}

	private void setReference(String reference) {
		this.reference = TextHelper.applyTrim(reference);
	}

	public String getDescription() {
		return description;
	}

	private void setDescription(String description) {
		this.description = TextHelper.applyTrim(description);
	}

	public GarmentConfigurationDomain getGarmentConfiguration() {
		return garmentConfiguration;
	}

	private void setGarmentConfiguration(GarmentConfigurationDomain garmentConfiguration) {
		this.garmentConfiguration = ObjectHelper.getDefault(garmentConfiguration, GarmentConfigurationDomain.create());
	}

	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
