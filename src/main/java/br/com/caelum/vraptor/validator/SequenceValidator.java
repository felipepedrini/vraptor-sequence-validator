package br.com.caelum.vraptor.validator;

import br.com.caelum.vraptor.Validator;

/**
 * An extended validator for vraptor 3. Uses interfaces to group and order
 * validations (following the JSR03 specification).
 * 
 * @author Felipe Pedrini
 * 
 */
public interface SequenceValidator extends Validator {

	/**
	 * Validates an object using marker interfaces classes as groups.
	 * 
	 * @param object
	 *            object to be validated
	 * @param groups
	 *            classes representing validation groups
	 */
	void validate(Object object, Class<?>... groups);
}
