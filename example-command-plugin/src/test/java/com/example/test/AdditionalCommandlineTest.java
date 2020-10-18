package com.example.test; /*
                          ========================================================================
                          SchemaCrawler
                          http://www.schemacrawler.com
                          Copyright (c) 2000-2020, Sualeh Fatehi <sualeh@hotmail.com>.
                          All rights reserved.
                          ------------------------------------------------------------------------

                          SchemaCrawler is distributed in the hope that it will be useful, but
                          WITHOUT ANY WARRANTY; without even the implied warranty of
                          MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.

                          SchemaCrawler and the accompanying materials are made available under
                          the terms of the Eclipse Public License v1.0, GNU General Public License
                          v3 or GNU Lesser General Public License v3.

                          You may elect to redistribute this code under any of these licenses.

                          The Eclipse Public License is available at:
                          http://www.eclipse.org/legal/epl-v10.html

                          The GNU General Public License v3 and the GNU Lesser General Public
                          License v3 are available at:
                          http://www.gnu.org/licenses/

                          ========================================================================
                          */

import static org.hamcrest.MatcherAssert.assertThat;
import static schemacrawler.test.utility.CommandlineTestUtility.commandlineExecution;
import static schemacrawler.test.utility.FileHasContent.classpathResource;
import static schemacrawler.test.utility.FileHasContent.hasSameContentAs;
import static schemacrawler.test.utility.FileHasContent.outputOf;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import schemacrawler.schemacrawler.InfoLevel;
import schemacrawler.test.utility.DatabaseConnectionInfo;
import schemacrawler.test.utility.TestAssertNoSystemErrOutput;
import schemacrawler.test.utility.TestAssertNoSystemOutOutput;
import schemacrawler.test.utility.TestDatabaseConnectionParameterResolver;
import schemacrawler.tools.options.TextOutputFormat;

@ExtendWith(TestAssertNoSystemErrOutput.class)
@ExtendWith(TestAssertNoSystemOutOutput.class)
@ExtendWith(TestDatabaseConnectionParameterResolver.class)
public class AdditionalCommandlineTest {

  @Test
  public void commandlineAdditional(final DatabaseConnectionInfo connectionInfo) throws Exception {
    final Map<String, String> argsMap = new HashMap<>();
    argsMap.put("-info-level", InfoLevel.standard.name());

    assertThat(
        outputOf(
            commandlineExecution(connectionInfo, "additional", argsMap, TextOutputFormat.text)),
        hasSameContentAs(classpathResource("command_output.txt")));
  }
}
