package com.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static schemacrawler.test.utility.CommandlineTestUtility.commandlineExecution;
import static schemacrawler.test.utility.FileHasContent.classpathResource;
import static schemacrawler.test.utility.FileHasContent.hasSameContentAs;
import static schemacrawler.test.utility.FileHasContent.outputOf;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import schemacrawler.schemacrawler.InfoLevel;
import schemacrawler.test.utility.AssertNoSystemErrOutput;
import schemacrawler.test.utility.AssertNoSystemOutOutput;
import schemacrawler.test.utility.DatabaseConnectionInfo;
import schemacrawler.test.utility.WithTestDatabase;
import schemacrawler.tools.command.text.schema.options.TextOutputFormat;

@AssertNoSystemErrOutput
@AssertNoSystemOutOutput
@WithTestDatabase
public class AdditionalCommandlineTest {

  @Test
  public void commandlineAdditional(final DatabaseConnectionInfo connectionInfo) throws Exception {
    final Map<String, String> argsMap = new HashMap<>();
    argsMap.put("--info-level", InfoLevel.standard.name());

    assertThat(
        outputOf(
            commandlineExecution(connectionInfo, "additional", argsMap, TextOutputFormat.text)),
        hasSameContentAs(classpathResource("command_output.txt")));
  }
}
