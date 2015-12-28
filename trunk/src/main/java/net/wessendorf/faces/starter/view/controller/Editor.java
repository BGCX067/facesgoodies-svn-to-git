package net.wessendorf.faces.starter.view.controller;

import org.apache.myfaces.orchestra.conversation.ConversationBindingEvent;
import org.apache.myfaces.orchestra.conversation.ConversationBindingListener;
import org.apache.myfaces.orchestra.conversation.annotations.ConversationRequire;
import org.apache.myfaces.orchestra.viewController.annotations.PreRenderView;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;

import com.company.User;

@ConversationRequire(conversationNames = "editor", entryPointViewIds = {"/all.xhtml"},
    redirect="/all.xhtml")
@ViewController(viewIds={"/edit1.xhtml", "/edit2.xhtml"})
public class Editor extends AbstractBaseController implements ConversationBindingListener
{
  private Long userId;
  private User user;

  public Editor()
  {
  }
  
  @PreRenderView public void loader()
  {
    if(user == null)
    {
      user = getUserService().queryUserById(userId);
    }
  }
  
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String next()
  {
    return "next";
  }
  
  public String back()
  {
    return "back";
  }
  
  public String save()
  {
    getUserService().saveUser(user);
    return "save";
  }

  public void valueBound(ConversationBindingEvent event)
  {
    System.out.println("EditorBean added");
  }

  public void valueUnbound(ConversationBindingEvent event)
  {
    System.out.println("Editor-Bean removed");
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }
}
