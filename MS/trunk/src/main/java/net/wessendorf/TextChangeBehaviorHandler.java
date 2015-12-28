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

import java.util.Collection;

import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.component.behavior.Behavior;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.BehaviorConfig;
import javax.faces.view.facelets.BehaviorHandler;
import javax.faces.view.facelets.FaceletContext;
import javax.faces.view.facelets.TagException;

public class TextChangeBehaviorHandler extends BehaviorHandler
{

  public TextChangeBehaviorHandler(BehaviorConfig config)
  {
    super(config);
  }

  @Override
  public void apply(FaceletContext ctx, UIComponent parent)
  {
    ClientBehaviorHolder holder = _getClientBehaviorHolder(parent);

    FacesContext context = ctx.getFacesContext();
    Application app = context.getApplication();
    String behaviorId = getBehaviorId();
    Behavior behavior = app.createBehavior(behaviorId);
    assert(behavior instanceof ClientBehavior);

    setAttributes(ctx, behavior);

    ClientBehavior clientBehavior = (ClientBehavior)behavior;
    
    // registry...
    holder.addClientBehavior(TextChangeBehavior.MOUSE_OUT, clientBehavior);
    holder.addClientBehavior(TextChangeBehavior.MOUSE_OVER, clientBehavior);
  }
  
  private ClientBehaviorHolder _getClientBehaviorHolder(UIComponent parent)
  {
    // Make sure that the parent component supports our required contract
    if (!(parent instanceof ClientBehaviorHolder))
    {
      throw new TagException(getTag(), 
        "TextChangeBehavior must be attached to a ClientBehaviorHolder parent.");
    }

    ClientBehaviorHolder holder = (ClientBehaviorHolder)parent;

    _checkEvent(holder, TextChangeBehavior.MOUSE_OUT);
    _checkEvent(holder, TextChangeBehavior.MOUSE_OVER);

    return holder;
  }


  // Tests whether the ClientBehaviorHolder supports the specified
  // event name.
  private void _checkEvent(
    ClientBehaviorHolder holder,
    String               eventName
    )
  {
    Collection<String> eventNames = holder.getEventNames();

    if (!eventNames.contains(eventName))
    {
      StringBuilder message = new StringBuilder();
      message.append("Unable to attach TextChangeBehavior.  ");
      message.append("TextChangeBeahvior may only be attached to ");
      message.append("ClientBehaviorHolders that support the '");
      message.append(eventName);
      message.append("' event.  The parent ClientBehaviorHolder only ");
      message.append("supports the following events: ");

      for (String supportedEventName : eventNames)
      {
        message.append(supportedEventName);
        message.append(" ");
      }

      throw new TagException(getTag(), message.toString());
    }
  }
  
}