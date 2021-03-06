/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.aws.alexa.annotation;

import io.micronaut.aop.Adapter;
import io.micronaut.aws.alexa.handlers.AnnotatedRequestHandler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * This annotation can be used on bean methods to make any method a {@link com.amazon.ask.dispatcher.request.handler.RequestHandler}, simplifying the Alexa programming model.
 *
 * <pre class="code">
 * &#064;Singleton
 * public class AlexApplication {
 *
 *     &#064;IntentHandler("HelloWorldIntent")
 *     public Optional<Response> greet(HandlerInput input) {
 *         // intent logic here
 *     }
 * }</pre>
 *
 *
 * @author graemerocher
 * @since 1.1
 */
@Documented
@Retention(RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Adapter(AnnotatedRequestHandler.class) 
public @interface IntentHandler {
    /**
     * @return The names of the intents to handle.
     */
    String[] value();
}
