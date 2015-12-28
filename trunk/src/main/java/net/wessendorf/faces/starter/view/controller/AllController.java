package net.wessendorf.faces.starter.view.controller;

import java.util.List;

import javax.faces.context.FacesContext;

import org.apache.myfaces.orchestra.conversation.Conversation;
import org.apache.myfaces.orchestra.conversation.ConversationManager;
import org.apache.myfaces.orchestra.viewController.annotations.InitView;
import org.apache.myfaces.orchestra.viewController.annotations.PreRenderView;
import org.apache.myfaces.orchestra.viewController.annotations.ViewController;
import org.apache.myfaces.trinidad.component.UIXTable;
import org.apache.myfaces.trinidad.context.RequestContext;
import org.apache.myfaces.trinidad.event.LaunchEvent;
import org.apache.myfaces.trinidad.event.ReturnEvent;

import com.company.User;

@ViewController(viewIds={"/all.xhtml"})
public class AllController extends AbstractBaseController
{
  private User toDelete = null;
  private List<User> users;

  @InitView @PreRenderView public void loadUsers()
  {
    this.users = getUserService().queryAllUsers();
    Conversation currentConv = ConversationManager.getInstance().getConversation("editor");
    if(currentConv != null)
    {
      currentConv.invalidate();  
    }
  }

  public String deleteUser()
  {
    getUserService().removeUser(toDelete);
    
    //fake a heavy transaction.....
    //this hack is only, to show ajax-api...
    try
    {
      Thread.sleep(1500);
    } catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    
    loadUsers();

    UIXTable table = (UIXTable) FacesContext.getCurrentInstance().getViewRoot().findComponent("userTable");
    table.setValue(this.users);
    RequestContext afContext = RequestContext.getCurrentInstance();
    afContext.addPartialTarget(table); 
    
    return null;
  }

  public User getToDelete()
  {
    return toDelete;
  }

  public void setToDelete(User toDelete)
  {
    this.toDelete = toDelete;
  }

  public List<User> getUsers()
  {
    return users;
  }
  
  
  public void googleMap(ReturnEvent event)
  {
    Conversation currentConv = ConversationManager.getInstance().getConversation("googleMap");
    currentConv.invalidate();  
  }
  
  public void handleReturn(ReturnEvent event)
  {
    User u = (User) event.getReturnValue();
    getUserService().updateUser(u);
    loadUsers();
    
    UIXTable table = (UIXTable) event.getComponent().findComponent("userTable");
    table.setValue(this.users);
    RequestContext afContext = RequestContext.getCurrentInstance();
    afContext.addPartialTarget(table); 
  }

  public void startMap(LaunchEvent e)
  {
  }
  
  public void setUsers(List<User> users)
  {
    this.users = users;
  }
}