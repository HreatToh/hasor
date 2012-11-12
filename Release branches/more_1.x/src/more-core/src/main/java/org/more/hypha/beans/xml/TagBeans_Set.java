/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.more.hypha.beans.xml;
import java.util.HashSet;
import org.more.core.xml.XmlStackDecorator;
import org.more.hypha.context.xml.XmlDefineResource;
import org.more.hypha.define.Set_ValueMetaData;
/**
 * 用于解析set标签
 * @version 2010-9-16
 * @author 赵永春 (zyc@byshell.org)
 */
public class TagBeans_Set extends TagBeans_AbstractCollection<Set_ValueMetaData> {
    /**创建{@link TagBeans_Set}对象*/
    public TagBeans_Set(XmlDefineResource configuration) {
        super(configuration);
    }
    /**创建{@link Set_ValueMetaData}对象*/
    protected Set_ValueMetaData createDefine(XmlStackDecorator<Object> context) {
        return new Set_ValueMetaData();
    }
    protected Class<?> getDefaultCollectionType() {
        return HashSet.class;
    }
}