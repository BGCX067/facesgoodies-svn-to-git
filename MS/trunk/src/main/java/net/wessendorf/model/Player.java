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
package net.wessendorf.model;

public class Player
{

  public Player()
  {

  }

  public Player(String f, String n, String c)
  {
    id = counter;
    firstname = f;
    secondname = n;
    club = c;
    counter++;
  }

  public String getFirstname()
  {
    return firstname;
  }

  public void setFirstname(String firstname)
  {
    this.firstname = firstname;
  }

  public String getSecondname()
  {
    return secondname;
  }

  public void setSecondname(String secondname)
  {
    this.secondname = secondname;
  }

  public String getClub()
  {
    return club;
  }

  public void setClub(String club)
  {
    this.club = club;
  }

  public int getId()
  {
    return id;
  }

  private String firstname;
  private String secondname;
  private String club;

  private int id;

  private static int counter = 0;
}