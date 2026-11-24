package com.reflection;

import java.lang.reflect.Method;

public class UseReflection {

	public static void main( String[] args ) {
		Employee e1 = new Employee();
		Class<?> cls = e1.getClass();
		System.out.println( "Package Name: " + cls.getPackageName() );
		System.out.println( "Class Name: " + cls.getSimpleName() );
		System.out.println( "Class name and package: " + cls.getName() );
		System.out.println( "Is Interface?: " + cls.isInterface() );

		Method[] arr = cls.getMethods();
		System.out.println( "Methods: " );

		for ( final Method m : arr ) {
			System.out.println( m.toGenericString() );
		}
	}

}
