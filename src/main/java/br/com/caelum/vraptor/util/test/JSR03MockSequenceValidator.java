package br.com.caelum.vraptor.util.test;

import javax.validation.MessageInterpolator;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import br.com.caelum.vraptor.validator.JSR303SequenceValidator;
import br.com.caelum.vraptor.validator.MessageInterpolatorFactory;
import br.com.caelum.vraptor.validator.SequenceValidator;

/**
 * Mock implementation of {@link SequenceValidator} that uses JSR303 underneath.
 * 
 * @author Felipe Pedrini
 * 
 */
public class JSR03MockSequenceValidator extends MockValidator implements SequenceValidator {
	private JSR303SequenceValidator that;
	private static final ValidatorFactory validatorFactory;

	static {
		validatorFactory = Validation.buildDefaultValidatorFactory();
	}

	public JSR03MockSequenceValidator() {
		Validator validator = validatorFactory.getValidator();
		MessageInterpolatorFactory factoryMessageInterpolator = new MessageInterpolatorFactory(validatorFactory);

		// @PostConstruct not works out of container.
		factoryMessageInterpolator.createInterpolator();
		MessageInterpolator interpolator = factoryMessageInterpolator.getInstance();

		that = new JSR303SequenceValidator(new MockLocalization(), validator, interpolator);
	}

	@Override
	public void validate(Object object, Class<?>... groups) {
		addAll(that.validate(object, groups));
	}
}
