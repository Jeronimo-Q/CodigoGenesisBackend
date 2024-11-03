package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import co.com.munamu.crosscutting.helpers.ObjectHelper;
import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;
import co.com.munamu.munamuinventory.businesslogic.adapter.Adapter;
import co.com.munamu.munamuinventory.domain.SizeDomain;
import co.com.munamu.munamuinventory.dto.SizeDTO;

public final class SizeDTOAdapter implements Adapter<SizeDomain,SizeDTO> {
	
	private static final Adapter<SizeDomain,SizeDTO> instance = new SizeDTOAdapter();
	
	private SizeDTOAdapter() {
		
	}
	public static Adapter<SizeDomain,SizeDTO> getSizeDTOAdapter(){
		return instance;
	}
	
	@Override
	    public SizeDomain adaptTarjet(final SizeDTO data) {
		var dtoToAdapt=ObjectHelper.getDefault(data,SizeDTO.create());
		return SizeDomain.create(UUIDHelper.convertToUUID(dtoToAdapt.getId()),data.getName());
	    }

	    @Override
	    public SizeDTO adaptSource(final SizeDomain data) {
			var domainToAdapt=ObjectHelper.getDefault(data,SizeDomain.create(UUIDHelper.getDefault(),TextHelper.EMPTY));
			return SizeDTO.create().setId(TextHelper.EMPTY).setName(domainToAdapt.getName());
	    
}
}
