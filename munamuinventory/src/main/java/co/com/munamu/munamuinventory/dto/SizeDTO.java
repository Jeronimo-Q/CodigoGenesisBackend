package co.com.munamu.munamuinventory.dto;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class SizeDTO extends DomainDTO{
	
	private String name;
	
	public SizeDTO() {
		super(UUIDHelper.getDefaultAssString());
		setName(TextHelper.EMPTY);
	}
	
	public static final SizeDTO create() {
		return new SizeDTO();
	}

	public String getName() {
		return name;
	}

	public SizeDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	

	public SizeDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public  String getId() {
		return super.getId();
	}
	
	

	
}
