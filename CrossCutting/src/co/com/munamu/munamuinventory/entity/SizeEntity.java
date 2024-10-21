package co.com.munamu.munamuinventory.entity;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class SizeEntity extends DomainEntity{
	
	private String name;
	
	public SizeEntity() {
		super(UUIDHelper.getDefault());
		setName(TextHelper.EMPTY);
	}
	
	public static final SizeEntity create() {
		return new SizeEntity();
	}

	public String getName() {
		return name;
	}

	public SizeEntity setName(final String name) {
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
