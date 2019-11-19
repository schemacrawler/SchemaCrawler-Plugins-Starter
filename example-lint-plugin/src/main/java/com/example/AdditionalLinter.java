package com.example;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

import schemacrawler.schema.Table;
import schemacrawler.tools.lint.BaseLinter;
import schemacrawler.tools.lint.LintObjectType;

public class AdditionalLinter
  extends BaseLinter
{

  private static final Logger LOGGER = Logger
    .getLogger(AdditionalLinter.class.getName());

  @Override
  public String getSummary()
  {
    return "table names should start with FOO_";
  }

  @Override
  protected void lint(final Table table, final Connection connection)
  {
    if (table != null)
    {
      if (!table.getName().startsWith("FOO_"))
      {
        // SchemaCrawler will control output of log messages if you use
        // JDK logging
        LOGGER
          .log(Level.INFO,
               String.format("Adding lint for table <%s>", table));

        addLint(LintObjectType.table, table, getSummary(), table.getFullName());
      }
    }
  }

}
