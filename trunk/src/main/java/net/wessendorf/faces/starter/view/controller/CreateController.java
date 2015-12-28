package net.wessendorf.faces.starter.view.controller;

import javax.faces.context.FacesContext;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

import com.company.User;

public class CreateController extends AbstractBaseController
{

  public void initView()
  {
  }
  
  public void preRenderView()
  {
  }
  
  private User user = new User();

  public String createUser()
  {
    getUserService().saveUser(this.user);
    
    FacesContext context = FacesContext.getCurrentInstance();
    ExtendedRenderKitService erks =
      Service.getRenderKitService(context,
                                ExtendedRenderKitService.class);
    erks.addScript(context,
                 "hello('" +
                 this.user.getSecondname() + ", " + this.user.getFirstname() +
                 "');");

    
    return ("success");
  }
  
  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

}