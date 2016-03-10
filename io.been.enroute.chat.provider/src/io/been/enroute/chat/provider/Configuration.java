package io.been.enroute.chat.provider;

import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition
@interface Configuration {
	String user_name() default "osgi";
}
