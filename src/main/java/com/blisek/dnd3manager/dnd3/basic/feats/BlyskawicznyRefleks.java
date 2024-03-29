package com.blisek.dnd3manager.dnd3.basic.feats;

import java.util.Map;

import com.blisek.dnd3manager.dnd3.AbstractFeat;
import com.blisek.dnd3manager.dnd3.CreatureModel;
import com.blisek.dnd3manager.dnd3.StringConstants;

public class BlyskawicznyRefleks extends AbstractFeat {
	private static final String SYSTEM_NAME = "blyskawiczny_refleks";
	private final String REFLEX_NAME;
	
	public BlyskawicznyRefleks() {
		REFLEX_NAME = String.format("%s_%s", StringConstants.REFLEX, BlyskawicznyRefleks.SYSTEM_NAME);
	}

	@Override
	public boolean isAvailableFor(CreatureModel model, Map<String, Object> extraParams) {
		return !model.getFeatsMap().containsKey(getSystemName());
	}

	@Override
	public String getSystemName() {
		return BlyskawicznyRefleks.SYSTEM_NAME;
	}

	@Override
	public void turnOnFor(CreatureModel model, Map<String, Object> extraParams) {
		model.put(REFLEX_NAME, 2);
		model.getFeatsMap().put(BlyskawicznyRefleks.SYSTEM_NAME, 1);
	}

	@Override
	public void turnOffFor(CreatureModel model, Map<String, Object> extraParams) {
		model.remove(REFLEX_NAME);
		model.getFeatsMap().remove(getSystemName());
	}

	@Override
	public boolean isPassive() {
		return true;
	}

}
