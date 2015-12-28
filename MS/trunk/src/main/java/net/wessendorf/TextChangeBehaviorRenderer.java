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
package net.wessendorf;

import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.render.ClientBehaviorRenderer;
import javax.faces.render.FacesBehaviorRenderer;

@FacesBehaviorRenderer(rendererType = "net.wessendorf.Change")
@ResourceDependencies({ 
  //@ResourceDependency(name="wessi.js", library="wessi", target="head")
  // TARGET handling is fixed in REV: 903595
  @ResourceDependency(name="wessi.js", library="wessi")
})
public class TextChangeBehaviorRenderer extends ClientBehaviorRenderer
{

  @Override
  public String getScript(ClientBehaviorContext behaviorContext,
      ClientBehavior behavior)
  {
    String eventName = behaviorContext.getEventName();

    if ((TextChangeBehavior.MOUSE_OVER).equals(behaviorContext.getEventName()))
      return "wessi.mouseover(this);";

    if ((TextChangeBehavior.MOUSE_OUT).equals(behaviorContext.getEventName()))
      return "wessi.mouseout(this);";

    throw new IllegalStateException("Unknown event name: " + eventName);
  }

}
