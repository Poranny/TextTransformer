package pl.put.poznan.transformer.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.put.poznan.transformer.logic.ScenarioAnalyzer;

@SpringBootApplication
public class TransformerApplication {

    public static void main(String[] args) {

        if (args.length > 0) {
            // Jeśli podano argument (ścieżkę do pliku lokalnie), to wykonaj dla pliku lokalnego
            String filePath = args[0];
            ScenarioAnalyzer analyzer = new ScenarioAnalyzer();
            String result = analyzer.analyzeScenarioFromFile(filePath);
            System.out.println(result);
        }

        else {
            // W przeciwnym razie uruchom jako aplikację Spring Boot
            SpringApplication.run(TransformerApplication.class, args);
        }
    }
}
