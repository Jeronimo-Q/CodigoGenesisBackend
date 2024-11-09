package co.com.munamu.munamuinventory.businesslogic.usecase.garmentconfiguration;

import java.util.List;

import co.com.munamu.munamuinventory.businesslogic.usecase.UseCaseWithReturn;
import co.com.munamu.munamuinventory.domain.GarmentConfigurationDomain;

public interface FindGarmentConfiguration extends UseCaseWithReturn<GarmentConfigurationDomain,List<GarmentConfigurationDomain>>{
	
}
