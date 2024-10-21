package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class TypeGarmentDomain extends Domain{
	
	private String name;
	
	private TypeGarmentDomain(final UUID id , final String name) {
		super (id);
		setName(name);
	}
	
	public static final TypeGarmentDomain create(final UUID id , final String name) {
		return new TypeGarmentDomain(id, name);
	}
	
	static final TypeGarmentDomain create() {
		return new TypeGarmentDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
	}

	public String getName() {
		return name;
	}

	private void setName(final String name) {
		this.name = TextHelper.applyTrim(name);
	}
	
	@Override
	public  UUID getId() {
		return super.getId();
	}
	
}
