package de.jug.cologne.jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

@ManagedBean()
@SessionScoped
public class TestBean implements Serializable {
  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void goodBye(ActionEvent event) {
    value = "Good Bye!";
  }

  public void hello(ActionEvent event) {
    value = "Hello!";
  }
}
