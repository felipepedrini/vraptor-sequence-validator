package br.com.caelum.vraptor.validator;

import java.util.List;

/**
 * Extends the BeanValidator interface adding ways to group validations creating
 * a sequenced validation. Follows the JSR303 spec.
 * 
 * @author Felipe Pedrini
 * 
 */
public interface SequenceBeanValidator extends BeanValidator {

	/**
	 * Validates an object using marker interfaces classes as groups.
	 * 
	 * @param object
	 *            object to be validated
	 * @param groups
	 *            classes representing validation groups
	 * @return list of error messages if occurs
	 */
	public List<Message> validate(Object object, Class<?>... groups);
}
