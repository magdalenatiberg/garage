###Validators

A whole request should be validated when using the ValidatorFactory

###Business Services

####Input parameters
A request should always be used as input to a service.

####Response

#####Error
A message should be provided as well as a code


### Integration services

No response is needed for services that are of type create, update or delete if there are no specific errors to return. 

Should integration services also return a response? For now: no. 