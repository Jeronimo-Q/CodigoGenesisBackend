package co.com.munamu.munamuinventory.businesslogic.adapter.dto;

import java.util.ArrayList;
import java.util.List;

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
		@Override
		public List<SizeDTO> adaptSource(List<SizeDomain> data) {
			var results = new ArrayList<SizeDTO>();
			
			for (SizeDomain domain:data) {
				results.add(adaptSource(domain));
			}
			
			return results;
		}
		@Override
		public List<SizeDomain> adaptTarjet(List<SizeDTO> data) {
			var results = new ArrayList<SizeDomain>();
			
			for (SizeDTO entity:data) {
				results.add(adaptTarjet(entity));
			}
			
			return results;
		}
}
