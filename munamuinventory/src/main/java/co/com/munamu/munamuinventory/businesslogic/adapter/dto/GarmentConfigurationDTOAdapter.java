package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.CategoryDomain;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;
import co.com.munamu.munamuinventory.dto.CategoryDTO;
import co.com.munamu.munamuinventory.dto.GarmentConfigurationDTO;

public class GarmentConfigurationDTOAdapter implements Adapter<GarmentConfigurationDomain,GarmentConfigurationDTO> {
	 @Override
	    public GarmentConfigurationDomain adaptSource(final GarmentConfigurationDTO data) {
		 return null;
	    }

	    @Override
	    public GarmentConfigurationDTO adaptTarget(final GarmentConfigurationDomain data) {
	    	return null;
	    }
}
