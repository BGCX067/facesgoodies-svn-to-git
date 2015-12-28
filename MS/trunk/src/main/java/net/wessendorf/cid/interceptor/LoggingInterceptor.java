/*
 * Copyright (C) 2010 Bernd Bohmann, Matthias Weßendorf.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.wessendorf.cid.interceptor;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Timer @Interceptor
public class LoggingInterceptor implements Serializable
{

  @AroundInvoke
  public Object logExecutionTime(InvocationContext ic) throws Exception
  {
    long start = System.currentTimeMillis();
    try
    {
      return ic.proceed();
    }
    catch (Exception e)
    {
      throw e;
    }
    finally
    {
      long time = System.currentTimeMillis() - start;
      String method = ic.getClass().getName();
      Logger.getLogger(LoggingInterceptor.class.getName()).log(Level.INFO,
          "*** Invocation of " + method + " took " + time + "ms");
    }
  }

  private static final long serialVersionUID = -5177400269788338930L;
}