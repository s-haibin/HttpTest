package com.hx;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * JavaBean������
 * 
 * @author hx
 * 
 * @version 1.0
 */
public class BeanUtils {

	/**
	 * bean���� ֧��bean��bean���� ֧��bean��map���� ֧��map��bean����
	 * 
	 * @param source
	 *            ����Դ
	 * @param target
	 *            Ŀ�����
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void copyProperties(Object source, Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		if (source instanceof Map) {
			Map sourcemap = (Map) source;
			mapCopyBean(sourcemap, target);
		} else if (target instanceof Map) {
			Map targetmap = (Map) target;
			beanCopyMap(source, targetmap);
		} else {
			beanCopyBean(source, target);
		}
	}

	/**
	 * map������bean
	 * 
	 * @param source
	 *            ����Դ
	 * @param target
	 *            Ŀ�����
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void mapCopyBean(Map source, Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method[] methods = target.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith("set")) {
				String prop = method.getName().substring(3, 4).toLowerCase()+ method.getName().substring(4);
				Object value=convertParameter(method.getParameterTypes()[0],source.get(prop));
				method.invoke(target,value);
			}
		}
	}

	/**
	 * bean������bean
	 * 
	 * @param source
	 *            ����Դ
	 * @param target
	 *            Ŀ�����
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void beanCopyBean(Object source, Object target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method[] sourceMethods = source.getClass().getMethods();
		Method[] targetMethods = target.getClass().getMethods();
		Map sourceMap = saveMethod(sourceMethods, "get");
		Map targetMap = saveMethod(targetMethods, "set");
		Set set = sourceMap.entrySet();
		for (Iterator iter = set.iterator(); iter.hasNext();) {
			Map.Entry entry = (Map.Entry) iter.next();
			Method sourceMethod = (Method) entry.getValue();
			Method targetMethod = (Method) targetMap.get(entry.getKey());
			if (targetMethod != null) {
				Object value=convertParameter(targetMethod.getParameterTypes()[0],sourceMethod.invoke(source,null));
				targetMethod.invoke(target,value);
			}
		}
	}

	/**
	 * bean������map
	 * 
	 * @param source
	 *            ����Դ
	 * @param target
	 *            Ŀ�����
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void beanCopyMap(Object source, Map target) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Method[] methods = source.getClass().getMethods();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith("get")) {
				String prop = method.getName().substring(3, 4).toLowerCase()
						+ method.getName().substring(4);
				target.put(prop, method.invoke(source, null));
			}
		}

	}

	/**
	 * ��Method���浽map
	 *
	 *            ���뷽������
	 * @param methods
	 *            ���󷽷�����
	 * @return ����map,��ʽΪkeyΪmethod��������valueΪobj(���뷽������)
	 */
	public static Map saveMethod(Method[] methods, String startsWith) {
		Map map = new HashMap();
		for (int i = 0; i < methods.length; i++) {
			Method method = methods[i];
			if (method.getName().startsWith(startsWith)) {
				String prop = method.getName().substring(3, 4).toLowerCase()
						+ method.getName().substring(4);
				map.put(prop, method);
			}
		}
		return map;
	}

	

	/**
	 * ת����������
	 *
	 *            ԴClass����
	 * @param obj
	 *            ֵObject
	 * @return ����object����
	 */
	public static Object convertParameter(Class clazz, Object obj) {
		Object param = null;
		if (clazz.isPrimitive()) {
			String classname = clazz.getName();
			String ovalue = obj.toString();
			if (classname.equals("byte")) {
				param = Byte.parseByte(ovalue);
			} else if (classname.equals("char")) {
				param = ovalue.toCharArray()[0];
			} else if (classname.equals("short")) {
				param = Short.parseShort(ovalue);
			} else if (classname.equals("int")) {
				param = Integer.parseInt(ovalue);
			} else if (classname.equals("long")) {
				param = Long.parseLong(ovalue);
			} else if (classname.equals("float")) {
				param = Float.parseFloat(ovalue);
			} else if (classname.equals("double")) {
				param = Double.parseDouble(ovalue);
			} else {
				param = Boolean.parseBoolean(ovalue);
			}
		} else {
			String classname = clazz.getName();
			if (classname.equals("java.lang.Byte")) {
				param = new Byte(obj.toString());
			} else if (classname.equals("java.lang.Character")) {
				param = new Character(obj.toString().toCharArray()[0]);
			} else if (classname.equals("java.lang.Short")) {
				param = new Short(obj.toString());
			} else if (classname.equals("java.lang.Integer")) {
				param =new  Integer(obj.toString());
			} else if (classname.equals("java.lang.Long")) {
				param = new Long(obj.toString());
			} else if (classname.equals("java.lang.Float")) {
				param =new Float(obj.toString());
			} else if (classname.equals("java.lang.Double")) {
				param = new Double(obj.toString());
			} else if(classname.equals("java.lang.Boolean")){
				param = new Boolean(obj.toString());
			}else{
				param = obj;
			}
		}
		return param;
	}

	/**
	 * ת����������
	 * 
	 * @param clazz
	 *            ԴClass����
	 * @param obj
	 *            ֵObject����
	 * @return ����object��������
	 */
	public static Object[] convertParameterValues(Class clazz, Object[] obj) {

		Object[] param = null;
		if (clazz.isPrimitive()) {
			String classname = clazz.getName();
			if (classname.equals("byte")) {
				param = obj;
			} else if (classname.equals("char")) {
				param = obj;
			} else if (classname.equals("short")) {
				param = obj;
			} else if (classname.equals("int")) {
				param = obj;
			} else if (classname.equals("long")) {
				param = obj;
			} else if (classname.equals("float")) {
				param = obj;
			} else if (classname.equals("double")) {
				param = obj;
			} else {
				param = obj;
			}
		} else {
			param = obj;
		}
		return param;
	}

}
