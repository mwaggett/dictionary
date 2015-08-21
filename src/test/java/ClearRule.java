import org.junit.rules.ExternalResource;

public class ClearRule extends ExternalResource {

  protected void before() { }

  protected void after() {
    Class.clear(); //change to whatever class names created
    // any other classes in app
  }
}
