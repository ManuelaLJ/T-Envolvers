package karate;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Configuration;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;


import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static karate.Infraestructure.util.ConstanstsManagement.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ManagementAcceptanceTests {
    @Test
    public void testALL(){
        Results results = Runner.path(CLASSPATHKARATE)
                .outputCucumberJson(TRUE)
                .tags(IGNORE)
                .parallel(ONE);
        generateReport(results.getReportDir());
        assertEquals(ZERO, results.getFailCount(), results.getErrorMessages());
    }

    private static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[]{JSON}, TRUE);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration configuration = new Configuration(new File(BUILD), PROYECT_NAME);
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, configuration);
        reportBuilder.generateReports();
    }
}
