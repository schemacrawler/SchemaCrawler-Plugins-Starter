package com.example;

import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import schemacrawler.schema.Column;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;
import schemacrawler.tools.executable.BaseSchemaCrawlerCommand;
import us.fatehi.utility.property.PropertyName;
import us.fatehi.utility.string.StringFormat;

/** SchemaCrawler command plug-in. */
public class AdditionalCommand extends BaseSchemaCrawlerCommand<AdditionalCommandOptions> {

  private static final Logger LOGGER = Logger.getLogger(AdditionalCommand.class.getName());

  static final PropertyName COMMAND = new PropertyName("additional", "Additional SchemaCrawler functionality");

  protected AdditionalCommand() {
    super(COMMAND);
  }

  @Override
  public void checkAvailability() throws RuntimeException {
    // TODO: Check environment (classpath, external resources) to see if command can be executed
  }

  @Override
  public void execute() {
    // TODO: Possibly process options

    try (final PrintWriter writer = outputOptions.openNewOutputWriter(); ) {
      for (final Schema schema : catalog.getSchemas()) {
        // SchemaCrawler will control output of log messages if you use
        // JDK logging
        LOGGER.log(Level.INFO, new StringFormat("Processing <%s>", schema));
        for (final Table table : catalog.getTables(schema)) {
          writer.println("o--> " + table);
          for (final Column column : table.getColumns()) {
            writer.println("     o--> " + column);
          }
        }
      }
    }
  }
}
