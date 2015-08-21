import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class WordTest {

  @Rule
  public ClearRule clearRule = new ClearRule();

  @Test
  public void word_instantiatesCorrectly() {
    Word testWord = new Word("house");
    assertEquals(true, testWord instanceof Word);
  }

  @Test
  public void word_instantiationAddsToInstances() {
    Word testWord = new Word("house");
    assertEquals(1, Word.all().size());
  }

  @Test
  public void getName_returnsName() {
    Word testWord = new Word("house");
    assertEquals("house", testWord.getName());
  }

  @Test
  public void getId_returnsWordId_1() {
    Word testWord = new Word("house");
    assertEquals(1, testWord.getId());
  }

  @Test
  public void getDefinitions_initiallyReturnsEmptyArrayList_0() {
    Word testWord = new Word("house");
    assertEquals(0, testWord.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsToDefinitions_1() {
    Word testWord = new Word("house");
    Definition testDef = new Definition("A building that people live in.");
    testWord.addDefinition(testDef);
    assertEquals(1, testWord.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsToDefinitions_true() {
    Word testWord = new Word("house");
    Definition testDef = new Definition("A building that people live in.");
    testWord.addDefinition(testDef);
    assertEquals(true, testWord.getDefinitions().contains(testDef));
  }

  @Test
  public void all_returnsAllInstancesOfWord_true() {
    Word testWord1 = new Word("house");
    Word testWord2 = new Word("mouse");
    assertTrue(Word.all().contains(testWord1));
    assertTrue(Word.all().contains(testWord2));
  }

  @Test
  public void clear_clearsInstances() {
    Word testWord = new Word("house");
    Word.clear();
    assertEquals(0, Word.all().size());
  }

  @Test
  public void find_returnsWordWithSameId() {
    Word testWord = new Word("house");
    assertEquals(Word.find(testWord.getId()), testWord);
  }

  @Test
  public void find_returnsNullIfNothingMatches() {
    assertEquals(null, Word.find(1));
  }

}
