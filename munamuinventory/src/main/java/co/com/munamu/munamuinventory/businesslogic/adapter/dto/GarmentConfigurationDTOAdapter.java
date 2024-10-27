package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.dto.GarmentConfigurationDTO;


public class GarmentConfigurationDTOAdapter implements Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> {
	private static final Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> instance = new GarmentConfigurationDTOAdapter();
	
	private GarmentConfigurationDTOAdapter() {
		
	}
	
	public static Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> getGarmentConfigurationEntityAdapter(){
		return instance;
	}
	
	@Override
	public GarmentConfigurationDomain adaptSource(final GarmentConfigurationDTO data) {
	    return null;
	}
	
	@Override
	public GarmentConfigurationDTO adaptTarget(final GarmentConfigurationDomain data) {
		return null;
	}
}
