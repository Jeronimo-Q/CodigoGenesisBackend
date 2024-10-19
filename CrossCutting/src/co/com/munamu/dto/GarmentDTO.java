package co.com.munamu.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class GarmentDTO extends DomainDTO{
	
	private int referencia;
	private String descripcion;
	private GarmentConfigurationDTO garmentConfiguration;
	
	public GarmentDTO() {
		super(UUIDHelper.getDefaultAssString());
		setGarmentConfiguration(GarmentConfigurationDTO.create());
		setDescripcion(TextHelper.EMPTY);
		//No olvidar que falta terminar lo que es lo de referncia
		
	}
	
	public static final GarmentDTO create() {
		return new GarmentDTO();
	}	

	public int getReferencia() {
		return referencia;
	}

	public GarmentDTO setReferencia(final int referencia) {
		this.referencia = referencia;
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
