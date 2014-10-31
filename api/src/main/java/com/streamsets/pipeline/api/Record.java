/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.streamsets.pipeline.api;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public interface Record {

  public static final String RESERVED_ATTRIBUTE_PREFIX = "_.";

  public static final String STAGE_INSTANCE_ATTR = RESERVED_ATTRIBUTE_PREFIX + "previous-stage";

  public static final String RECORD_SOURCE_ID_ATTR = RESERVED_ATTRIBUTE_PREFIX + "record-source-id";

  public static final String PROCESSING_PATH_ATTR = RESERVED_ATTRIBUTE_PREFIX + "processing-path";

  public interface Header {

    public byte[] getRaw();

    public String getRawMime();

    public Iterator<String> getAttributeNames();

    public String getAttribute(String name);

    public void setAttribute(String name, String value);

    public void removeAttribute(String name);

  }

  public Record getPreviousVersion();

  public Header getHeader();

  public Iterator<String> getFieldNames();

  public Field getField(String name);

  public void setField(String name, Field field);

  public void deleteField(String name);

  public String toString(Locale locale);

}
