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
package net.wessendorf.logger;

import java.util.logging.Logger;

public final class Log4JFactory
{
  
  private Log4JFactory()
  {
  }

  public static Logger createLogger(Class<?> c)
  {
    return createLogger(c.getName());
  }
  
  private static Logger createLogger(String name) 
  {
    return Logger.getLogger(name);
  }
}