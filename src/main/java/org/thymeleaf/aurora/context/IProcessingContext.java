/*
 * =============================================================================
 * 
 *   Copyright (c) 2011-2014, The THYMELEAF team (http://www.thymeleaf.org)
 * 
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 * 
 * =============================================================================
 */
package org.thymeleaf.aurora.context;

import java.util.Locale;

import org.thymeleaf.aurora.IEngineConfiguration;

/**
 *
 * @author Daniel Fern&aacute;ndez
 *
 * @since 2.0.9 (reimplemented in 3.0.0)
 * 
 */
public interface IProcessingContext {

    /*
     * This interface is similar to its child ITemplateProcessingContext, but it is non-template-execution bound.
     * The reason this exists is that some parts of the engine like e.g. the Thymeleaf Expression engine might
     * need to be executing outside the context of the execution of a template. For example, when resolving a
     * template fragment expression as the result of a SpringMVC controller or a Tiles attribute.
     */

    public IEngineConfiguration getConfiguration();

    public Locale getLocale();

    public IVariablesMap getVariablesMap();

}
