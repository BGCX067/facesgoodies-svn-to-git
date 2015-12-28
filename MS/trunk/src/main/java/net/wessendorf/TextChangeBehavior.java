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

import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.component.behavior.FacesBehavior;

@FacesBehavior("net.wessendorf.Change")
public class TextChangeBehavior extends ClientBehaviorBase
{
  @Override
  public String getRendererType()
  {
    return "net.wessendorf.Change";
  }

  public static final String MOUSE_OVER = "mouseover";
  public static final String MOUSE_OUT = "mouseout";
}