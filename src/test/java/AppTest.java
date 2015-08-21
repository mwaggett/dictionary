import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.fluentlenium.core.filter.FilterConstructor.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {

  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Dictionary!");
  }

  @Test
  public void homepage_navigatesToNewWordForm() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    assertThat(pageSource()).contains("What is your word?");
  }

  @Test
  public void newWordForm_addsWordToHomepage() {
    goTo("http://localhost:4567/");
    click("a", withText("Add a New Word"));
    fill("#newWord").with("house");
    submit(".btn");
    assertThat(pageSource()).contains("house");
  }
  // ^This doesn't work if I say goTo("http://localhost:4567/words/new");
  // Why is that?

}
