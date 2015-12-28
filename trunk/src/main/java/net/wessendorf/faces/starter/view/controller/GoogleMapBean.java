package net.wessendorf.faces.starter.view.controller;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.conversation.ConversationBindingListener;

import com.company.User;

public class GoogleMapBean extends AbstractBaseController implements ConversationBindingListener
{
  
  private Long userId;
  private User user;

  public User getUser()
  {
    this.user = getUserService().queryUserById(userId); 
    return user;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void valueBound(ConversationBindingEvent event)
  {
    System.out.println("GoogleMapBean added");
  }

  public void valueUnbound(ConversationBindingEvent event)
  {
    System.out.println("GoogleMapBean removed");
  }

}