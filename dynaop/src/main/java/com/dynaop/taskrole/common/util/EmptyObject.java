package com.dynaop.taskrole.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �����ж���ĳ������ǲ������޸ģ������������ò����޸ģ�����ָ��Ķ���Ҳ�����޸ģ���ʹ��ʱӦ��ע����һ�㣬��Ӧ������иı䡣���磺<br>
 * ����������
 * <pre>
 * EmptyObject.EMPTY_LIST.addAll(someList);
 * </pre>
 * ��ȷ������
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
