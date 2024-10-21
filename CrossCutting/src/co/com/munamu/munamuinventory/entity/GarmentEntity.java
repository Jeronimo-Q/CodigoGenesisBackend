package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentEntity extends DomainEntity{
	
	private String referencia;
	private String descripcion;
	private GarmentConfigurationDomain garmentConfiguration;
	
	public GarmentEntity() {
		super(UUIDHelper.getDefault());
		setGarmentConfiguration(GarmentConfigurationDomain.create());
		setDescripcion(TextHelper.EMPTY);
		setReferencia(TextHelper.EMPTY);
	}
	
	public static final GarmentEntity create() {
		return new GarmentEntity();
	}	

	public String getReferencia() {
		return referencia;
	}

	public GarmentEntity setReferencia(final String referencia) {
		this.referencia = TextHelper.applyTrim(referencia);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public GarmentEntity setDescripcion(final String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
		return this;
	}

	public GarmentConfigurationDomain getGarmentConfiguration() {
		return garmentConfiguration;
	}

	public GarmentEntity setGarmentConfiguration(final GarmentConfigurationDomain garmentConfiguration) {
		this.garmentConfiguration = ObjectHelper.getDefault(garmentConfiguration, GarmentConfigurationDomain.create());
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
