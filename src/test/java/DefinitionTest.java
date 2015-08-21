import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void definition_instantiatesCorrectly() {
    Definition testDef = new Definition("A building that people live in.");
    assertEquals(true, testDef instanceof Definition);
  }

  @Test
  public void definition_instantiationAddsToInstances() {
    Definition testDef = new Definition("A building that people live in.");
    assertEquals(1, Definition.all().size());
  }

  @Test
  public void getDescription_returnsDescription() {
    Definition testDef = new Definition("A building that people live in.");
    assertEquals("A building that people live in.", testDef.getDescription());
  }

  @Test
  public void getId_returnsDefinitionId() {
    Definition testDef = new Definition("A building that people live in.");
    assertEquals(1, testDef.getId());
  }

  @Test
  public void clear_clearsInstances() {
    Definition testDef = new Definition("A building that people live in.");
    Definition.clear();
    assertEquals(0, Definition.all().size());
  }

}
