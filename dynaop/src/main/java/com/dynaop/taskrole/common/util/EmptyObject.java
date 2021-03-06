package com.dynaop.taskrole.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 该类中定义的常量都是不可以修改（不仅仅是引用不可修改，引用指向的对象也不可修改），使用时应该注意这一点，不应对其进行改变。例如：<br>
 * 错误做法：
 * <pre>
 * EmptyObject.EMPTY_LIST.addAll(someList);
 * </pre>
 * 正确做法：
 * <pre>
 * someList.addAll(EmptyObject.EMPTY_LIST);
 * </pre>
 *
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public final class EmptyObject {

	public static final List EMPTY_LIST = Collections.unmodifiableList(new ArrayList(0));
	
	public static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
	
	public static final String[] EMPTY_STRING_ARRAY = new String[0];
	
	public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

}
