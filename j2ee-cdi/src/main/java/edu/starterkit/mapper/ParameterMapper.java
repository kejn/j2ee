package edu.starterkit.mapper;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ParameterMapper {

	private static String param2String(Object param) {
		return param.toString();
	}

	public static String objects2String(Object[] params) {
		return Arrays.asList(params).stream().map(ParameterMapper::param2String).collect(Collectors.joining(","));
	}

}
