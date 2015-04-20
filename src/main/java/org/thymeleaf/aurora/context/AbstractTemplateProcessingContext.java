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
import java.util.Map;

import org.thymeleaf.aurora.IEngineConfiguration;
import org.thymeleaf.aurora.engine.StandardModelFactory;
import org.thymeleaf.aurora.model.IModelFactory;
import org.thymeleaf.aurora.templatemode.TemplateMode;
import org.thymeleaf.util.Validate;

/**
 *
 * @author Daniel Fern&aacute;ndez
 * @since 3.0.0
 * 
 */
public abstract class AbstractTemplateProcessingContext
            extends AbstractProcessingContext
            implements ITemplateProcessingContext {

    private final String templateName;
    private final TemplateMode templateMode;
    private final IModelFactory modelFactory;




    public AbstractTemplateProcessingContext(
            final IEngineConfiguration configuration,
            final String templateName, final TemplateMode templateMode,
            final Locale locale, final IVariablesMap variablesMap) {

        super(configuration, locale, variablesMap);

        Validate.notNull(templateName, "Template Name cannot be null");
        Validate.notNull(templateMode, "Template Mode cannot be null");

        this.templateName = templateName;
        this.templateMode = templateMode;
        this.modelFactory =
                new StandardModelFactory(
                        this.templateMode, getConfiguration().getTextRepository(),
                        getConfiguration().getAttributeDefinitions(), getConfiguration().getElementDefinitions());

    }

    public AbstractTemplateProcessingContext(
            final IEngineConfiguration configuration,
            final String templateName, final TemplateMode templateMode,
            final IContext context) {

        super(configuration, context);

        Validate.notNull(templateName, "Template Name cannot be null");
        Validate.notNull(templateMode, "Template Mode cannot be null");

        this.templateName = templateName;
        this.templateMode = templateMode;
        this.modelFactory =
                new StandardModelFactory(
                        this.templateMode, getConfiguration().getTextRepository(),
                        getConfiguration().getAttributeDefinitions(), getConfiguration().getElementDefinitions());

    }

    public AbstractTemplateProcessingContext(
            final IEngineConfiguration configuration,
            final String templateName, final TemplateMode templateMode,
            final Locale locale, final Map<String, Object> variables) {

        super(configuration, locale, variables);

        Validate.notNull(templateName, "Template Name cannot be null");
        Validate.notNull(templateMode, "Template Mode cannot be null");

        this.templateName = templateName;
        this.templateMode = templateMode;
        this.modelFactory =
                new StandardModelFactory(
                        this.templateMode, getConfiguration().getTextRepository(),
                        getConfiguration().getAttributeDefinitions(), getConfiguration().getElementDefinitions());

    }



    public final String getTemplateName() {
        return this.templateName;
    }

    public final TemplateMode getTemplateMode() {
        return this.templateMode;
    }

    public final IModelFactory getModelFactory() {
        return this.modelFactory;
    }


}
