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
package org.apache.metron.enrichment.stellar;

import com.google.common.collect.Lists;
import org.apache.metron.common.dsl.FunctionResolverSingleton;
import org.apache.metron.common.dsl.Stellar;
import org.apache.metron.common.dsl.StellarFunction;
import org.apache.metron.common.dsl.StellarFunctionInfo;
import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.apache.metron.common.dsl.FunctionResolverSingleton.effectiveClassPathUrls;

public class DocumentationGenerator {

  public static void main(String... argv) {
    List<StellarFunctionInfo> functions = Lists.newArrayList(FunctionResolverSingleton.getInstance().getFunctionInfo());
    Collections.sort(functions, (o1, o2) -> o1.getName().compareTo(o2.getName()));
    for(StellarFunctionInfo info: functions) {
      System.out.println( "* `" + info.getName() + "`");
      System.out.println( "  * Description: " + info.getDescription() );
      System.out.println( "  * Input:");
      for(String param :info.getParams()) {
        System.out.println( "    * " + param );
      }
      System.out.println( "  * Returns: " + info.getReturns() );
    }
  }


}
