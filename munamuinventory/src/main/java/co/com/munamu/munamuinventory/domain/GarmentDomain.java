package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;


public class GarmentDomain extends Domain{
	
	private String referencia;
	private String descripcion;
	private GarmentConfigurationDomain garmentConfiguration;
	
	private GarmentDomain(final UUID id, final GarmentConfigurationDomain garmentConfiguration,final String descripcion,final String referencia) {
		super (id);
		setGarmentConfiguration(garmentConfiguration);
		setDescripcion(descripcion);
		setReferencia(referencia);
		
	}
	
	public static GarmentDomain create(final UUID id, final GarmentConfigurationDomain garmentConfiguration,final String descripcion,final String referencia) {
		return new GarmentDomain(id, garmentConfiguration, descripcion, referencia);
	}
	
	static final GarmentDomain create() {
		return new GarmentDomain(UUIDHelper.getDefault(), GarmentConfigurationDomain.create(), TextHelper.EMPTY,TextHelper.EMPTY);
	}
	
	public String getReferencia() {
		return referencia;
	}

	private void setReferencia(String referencia) {
		this.referencia = TextHelper.applyTrim(referencia);
	}

	public String getDescripcion() {
		return descripcion;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
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
