package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class TypeGarmentEntity extends DomainEntity{
	
	private String name;
	
	public TypeGarmentEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}
	
	public static final TypeGarmentEntity create() {
		return new TypeGarmentEntity();
	}

	public String getName() {
		return name;
	}

	public TypeGarmentEntity setName(final String name) {
		this.name = TextHelper.applyTrim(name);
		return this;
	}
	

	public void setId(final UUID id) {
		super.setId(id);
		
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}
	
	

	
}
