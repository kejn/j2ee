package edu.starterkit.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import edu.starterkit.mapper.ParameterMapper;

@Interceptor
@LogDetails
public class LoggerInterceptor {

	private LogDetails details; 
	
	@AroundInvoke
	public Object log(InvocationContext context) throws Exception {
		details = getClass().getAnnotation(LogDetails.class);
		if(details.printMethodNameAndParameters()) {
			printMethodNameAndParameters(context.getMethod().getName(), context.getParameters());
		}
		Object result = context.proceed();
		if(details.printReturnValue()) {
			printReturnValue(result);
		}
		return result;
	}
	
	private void printMethodNameAndParameters(String methodName, Object[] parameters) {
		StringBuilder methodDetails = new StringBuilder();
		methodDetails.append("Calling method: " + methodName);
		methodDetails.append("(" + ParameterMapper.objects2String(parameters) + ")");
		System.out.println(methodDetails.toString());
	}
	
	private void printReturnValue(Object result) {
		System.out.println("Result: " + result.toString());
	}
	
}
