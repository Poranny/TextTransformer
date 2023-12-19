package pl.put.poznan.transformer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.Scenario;
import pl.put.poznan.transformer.logic.ScenarioAnalyzer;

@RestController
@RequestMapping("/api/tools")
public class TransformerController {

    @Autowired
    private ScenarioAnalyzer scenarioAnalyzer;

    @GetMapping("/analyze")
    public ResponseEntity<String> analyzeScenario(@RequestParam("filePath") String filePath) {

        String result = scenarioAnalyzer.analyzeScenarioFromFile(filePath);
        return ResponseEntity.ok (result);
    }

    @PostMapping("/runFunction")
    public String runFunction(@RequestBody Scenario scenario) {

        return "Wynik funkcji dla scenariusza: " + scenario.toString();
    }
}
