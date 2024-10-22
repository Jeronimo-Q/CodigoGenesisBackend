package co.com.munamu.munamuinventory.dto;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class TypeGarmentDTO extends DomainDTO{
	
	private String name;
	
	public TypeGarmentDTO() {
		super(UUIDHelper.getDefaultAssString());
		setName(TextHelper.EMPTY);
	}
	
	public static final TypeGarmentDTO create() {
		return new TypeGarmentDTO();
	}

	public String getName() {
		return name;
	}

	public TypeGarmentDTO setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	

	public TypeGarmentDTO setId(final String id) {
		super.setIdentifier(id);
		return this;
	}
	
	@Override
	public  String getId() {
		return super.getId();
	}
	
	

	
}
