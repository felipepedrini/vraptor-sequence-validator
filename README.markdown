Extended implementation of vraptor validator.

Based on JSR303 spec that uses the groups property in validation annotations + @javax.validation.GroupSequence.

To use just inject the interface SequenceValidator instead of Validator in Controller and use the following method:

validator.validate(Object object, Class<?>... groups);

Here is a brief example how to use it: https://gist.github.com/1007965

Blog post about this project (in portuguese): http://fpedrini.posterous.com/usando-validacoes-com-prioridade-no-vraptor-3