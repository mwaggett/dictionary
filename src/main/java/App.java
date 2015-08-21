import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.*;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class App {

  public static void main(String[] args) {
    staticFileLocation("/public"); // Relative path for images, css, etc.
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      ArrayList<Word> words = request.session().attribute("words");
      if (words == null) {
        words = new ArrayList<Word>();
        request.session().attribute("words", words);
      }
      model.put("words", words);
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/new-word-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();

      ArrayList<Word> words = request.session().attribute("words");
      if (words == null) {
        words = new ArrayList<Word>();
        request.session().attribute("words", words);
      }

      Word newWord = new Word(request.queryParams("newWord"));
      words.add(newWord);
      model.put("words", words);

      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));

      ArrayList<Definition> definitions = request.session().attribute("definitions");
      if (definitions == null) {
        definitions = new ArrayList<Definition>();
        request.session().attribute("definitions", definitions);
      }
      definitions = word.getDefinitions();
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/words/:id/definitions/new", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));

      model.put("word", word);
      model.put("template", "templates/new-definition-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/words/:id", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      Word word = Word.find(Integer.parseInt(request.params(":id")));

      ArrayList<Definition> definitions = request.session().attribute("definitions");
      if (definitions == null) {
        definitions = new ArrayList<Definition>();
        request.session().attribute("definitions", definitions);
      }

      Definition newDef = new Definition(request.queryParams("newDef"));
      word.addDefinition(newDef);
      definitions = word.getDefinitions();
      model.put("word", word);
      model.put("definitions", definitions);
      model.put("template", "templates/word.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

}
