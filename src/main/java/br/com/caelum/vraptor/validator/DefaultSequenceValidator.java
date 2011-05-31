package br.com.caelum.vraptor.validator;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.Localization;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.RequestScoped;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.view.ValidationViewsFactory;

/**
 * Default implementation of SequenceValidator using groups interfaces to group
 * and order validations.
 * 
 * @author Felipe Pedrini
 * 
 */
@Component
@RequestScoped
public class DefaultSequenceValidator extends DefaultValidator implements SequenceValidator {
	private static final Logger logger = LoggerFactory.getLogger(DefaultSequenceValidator.class);

	private final List<SequenceBeanValidator> sequenceBeanValidators;

	public DefaultSequenceValidator(Result result, ValidationViewsFactory factory, Outjector outjector,
			Proxifier proxifier, List<BeanValidator> beanValidators, Localization localization,
			List<SequenceBeanValidator> sequenceBeanValidators) {
		super(result, factory, outjector, proxifier, beanValidators, localization);
		this.sequenceBeanValidators = sequenceBeanValidators;
	}

	public void validate(Object object, Class<?>... groups) {
		if (sequenceBeanValidators == null || sequenceBeanValidators.isEmpty()) {
			logger.warn("has no validators registered");
		} else {
			for (SequenceBeanValidator validator : sequenceBeanValidators) {
				addAll(validator.validate(object, groups));
			}
		}
	}

}
