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
package net.wessendorf.facesgoodies;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

import net.wessendorf.cid.injection.Carnival;
import net.wessendorf.cid.injection.GreetingService;
import net.wessendorf.cid.interceptor.Timer;
import net.wessendorf.enterprise.inject.SessionModel;

@SessionModel
public class HelloWorldBean implements Serializable
{
  @PostConstruct 
  public void postInit()
  {
  }
  
  public void setMessage(String message)
  {
    this.message = message;
  }

  public String getMessage()
  {
    return message;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public void goodBye(ActionEvent event)
  {
    value = "Good Bye!";
  }

  public void hello(ActionEvent event)
  {
    value = "Hello!";
  }
  
  @Timer 
  public String carnivalGreeting()
  {
System.out.println("\n\n @Injected Date: " + aDate + "\n\n");
    specialGreeting.sayHello();
    return null;
  }

  public String greeting()
  {
    greeting.sayHello();
    return null;
  }

  @Inject private Date aDate;
  @Inject @Carnival private GreetingService specialGreeting;
  @Inject  private GreetingService greeting;
  private String message = "JSF 2 and CDI, a nice combination!";
  private String value = null;
  private static final long serialVersionUID = -5709269270683489922L;
}