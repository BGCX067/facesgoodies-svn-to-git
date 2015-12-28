package net.wessendorf.faces.starter.view.controller;

import com.company.UserService;

public abstract class AbstractBaseController

{
  private UserService userService;
  
  public UserService getUserService()
  {
    return userService;
  }

  public void setUserService(UserService userService)
  {
    this.userService = userService;
  }  
}