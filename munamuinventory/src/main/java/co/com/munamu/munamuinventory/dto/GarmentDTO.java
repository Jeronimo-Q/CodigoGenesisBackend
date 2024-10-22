package co.com.munamu.munamuinventory.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentDTO extends DomainDTO{
	
	private String referencia;
	private String descripcion;
	private GarmentConfigurationDTO garmentConfiguration;
	
	public GarmentDTO() {
		super(UUIDHelper.getDefaultAssString());
		setGarmentConfiguration(GarmentConfigurationDTO.create());
		setDescripcion(TextHelper.EMPTY);
		setReferencia(TextHelper.EMPTY);
	}
	
	public static final GarmentDTO create() {
		return new GarmentDTO();
	}	

	public String getReferencia() {
		return referencia;
	}

	public GarmentDTO setReferencia(final String referencia) {
		this.referencia = TextHelper.applyTrim(referencia);
		return this;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public GarmentDTO setDescripcion(final String descripcion) {
		this.descripcion = TextHelper.applyTrim(descripcion);
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
