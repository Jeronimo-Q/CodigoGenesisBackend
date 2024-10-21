package co.com.munamu.munamuinventory.domain;

import java.util.UUID;

import co.com.munamu.crosscutting.helpers.TextHelper;
import co.com.munamu.crosscutting.helpers.UUIDHelper;

public class SizeDomain extends Domain{
	
	private String name;
	
	private SizeDomain(final UUID id , final String name) {
		super (id);
		setName(name);
	}
	
	public static SizeDomain create(final UUID id , final String name) {
		return new SizeDomain(id,name);
	}
	
	static final SizeDomain create() {
		return new SizeDomain(UUIDHelper.getDefault(), TextHelper.EMPTY);
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
