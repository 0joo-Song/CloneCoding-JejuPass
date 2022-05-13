package com.jejupass.config;

import java.util.Locale;

import org.apache.tiles.Definition;
import org.apache.tiles.definition.LocaleDefinitionsFactory;
import org.apache.tiles.definition.NoSuchDefinitionException;
import org.apache.tiles.request.Request;

/**
 * tiles 다국어 옵션 비활성화
 * @author rain
 *
 */
public class CustomLocaleDefinitionsFactory extends LocaleDefinitionsFactory {

	/** {@inheritDoc} */
	@Override
	public Definition getDefinition(String name, Request tilesContext) {
		Definition retValue;
		Locale locale = null;

		retValue = definitionDao.getDefinition(name, locale);
		if (retValue != null) {
			retValue = new Definition(retValue);
			String parentDefinitionName = retValue.getExtends();
			while (parentDefinitionName != null) {
				Definition parent = definitionDao.getDefinition(parentDefinitionName, locale);
				if (parent == null) {
					throw new NoSuchDefinitionException("Cannot find definition '" + parentDefinitionName
							+ "' ancestor of '" + retValue.getName() + "'");
				}
				retValue.inherit(parent);
				parentDefinitionName = parent.getExtends();
			}
		}

		return retValue;
	}
}