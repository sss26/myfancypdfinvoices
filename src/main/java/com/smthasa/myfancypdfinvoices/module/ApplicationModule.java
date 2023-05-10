package com.smthasa.myfancypdfinvoices.module;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.smthasa.myfancypdfinvoices.service.UserService;

public class ApplicationModule extends AbstractModule {

	@Provides
	public static UserService provideUserSerice() {
		return new UserService();
	}

	@Provides
	public static ObjectMapper provideObjectMapper() {
		return new ObjectMapper();
	}

}
