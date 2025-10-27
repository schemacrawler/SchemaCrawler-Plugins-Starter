package com.example.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static schemacrawler.test.utility.CommandlineTestUtility.commandlineExecution;
import static us.fatehi.test.utility.extensions.FileHasContent.classpathResource;
import static us.fatehi.test.utility.extensions.FileHasContent.hasSameContentAs;
import static us.fatehi.test.utility.extensions.FileHasContent.outputOf;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import schemacrawler.schemacrawler.InfoLevel;
import schemacrawler.test.utility.WithTestDatabase;
import schemacrawler.tools.command.text.schema.options.TextOutputFormat;
import us.fatehi.test.utility.DatabaseConnectionInfo;
import us.fatehi.test.utility.extensions.AssertNoSystemErrOutput;
import us.fatehi.test.utility.extensions.AssertNoSystemOutOutput;

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
