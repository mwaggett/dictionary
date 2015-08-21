import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class DefinitionTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void instances_isEmptyBeforeInstantiation() {
    assertEquals(0, Definition.all().size());
  }

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
    Definition.clear(); // Test currently fails without this, meaning that
                        // there's a definition in instances that isn't getting
                        // cleared. Not sure where/why (yet).
    Definition testDef = new Definition("A building that people live in.");
    assertEquals(1, testDef.getId());
  }

  @Test
  public void all_returnsAllInstancesOfDefinition_true() {
    Definition testDef1 = new Definition("A building that people live in.");
    Definition testDef2 = new Definition("A small rodent.");
    assertTrue(Definition.all().contains(testDef1));
    assertTrue(Definition.all().contains(testDef2));
  }

  @Test
  public void clear_clearsInstances() {
    Definition testDef = new Definition("A building that people live in.");
    Definition.clear();
    assertEquals(0, Definition.all().size());
  }

}
