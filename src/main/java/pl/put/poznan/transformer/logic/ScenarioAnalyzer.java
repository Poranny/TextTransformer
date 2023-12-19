package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ScenarioAnalyzer {

    private ObjectMapper objectMapper;

    public ScenarioAnalyzer() {

        // Inicjalizacja obiektu ObjectMapper, który jest używany do parsowania JSON
        this.objectMapper = new ObjectMapper();
    }

    public String analyzeScenarioFromFile(String filePath) {
        try {
            // Wczytaj dane scenariusza z pliku JSON
            String scenarioJson = new String(Files.readAllBytes(Paths.get(filePath)));

            // Analizuj scenariusz
            return analyzeScenario(scenarioJson);
        }

        catch (IOException e) {
            return "Błąd wczytywania pliku: " + e.getMessage();
        }
    }

    public String analyzeScenario(String scenarioJson) {
        try {
            JsonNode scenarioNode = objectMapper.readTree(scenarioJson);

            // Pobieranie nazwy scenariusza
            String scenarioName = scenarioNode.fieldNames().next();


            // Tutaj możesz dodać logikę analizy scenariusza na podstawie pobranych danych
            return "Wyniki analizy scenariusza: " + scenarioName;
        }

        catch (Exception e) {
            // Obsługa ewentualnych błędów parsowania JSON
            return "Błąd analizy scenariusza: " + e.getMessage();
        }
    }
    public static List<JsonNode> findMainAndAlternativeNodes(JsonNode rootNode) {

        List<JsonNode> returnNodes = new ArrayList<>();

        List<JsonNode> nodesToProcess = new ArrayList<>();
        nodesToProcess.add(rootNode);

        while (!nodesToProcess.isEmpty()) {
            JsonNode currentNode = nodesToProcess.remove (0);

            if (currentNode.isObject()) {
                Iterator <String> fieldNames = currentNode.fieldNames ();

                while (fieldNames.hasNext ()) {
                    String fieldName = fieldNames.next ();

                    if ("scenariusz_glowny".equals (fieldName)) {
                        returnNodes.add(currentNode.path("scenariusz_glowny"));

                        System.out.println("Found scenariusz_glowny!");

                        returnNodes.add(currentNode.path("scenariusze_alternatywne"));
                        System.out.println("Found scenariusze_alternatywne!");
                    }

                    nodesToProcess.add(currentNode.get(fieldName));
                }
            }

            else if (currentNode.isArray ()) {
                Iterator<JsonNode> elements = currentNode.elements();

                while (elements.hasNext ()) {
                    nodesToProcess.add(elements.next ());
                }
            }
        }

        return returnNodes;
    }


    public static void printJsonNodes(JsonNode rootNode) {

        List<JsonNode> nodesToProcess = new ArrayList<>();
        nodesToProcess.add(rootNode);

        while (!nodesToProcess.isEmpty()) {
            JsonNode currentNode = nodesToProcess.remove(0);

            if (currentNode.isObject()) {
                Iterator<String> fieldNames = currentNode.fieldNames();

                while (fieldNames.hasNext()) {
                    String fieldName = fieldNames.next();

                    System.out.println("Node Name: " + fieldName);

                    nodesToProcess.add(currentNode.get(fieldName));
                }
            }

            else if (currentNode.isArray()) {
                Iterator<JsonNode> elements = currentNode.elements();

                while (elements.hasNext()) {
                    nodesToProcess.add(elements.next());
                }
            }
        }
    }
}