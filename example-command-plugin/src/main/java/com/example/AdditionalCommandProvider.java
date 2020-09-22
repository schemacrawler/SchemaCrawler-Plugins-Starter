package com.example;

import schemacrawler.tools.executable.BaseCommandProvider;
import schemacrawler.tools.executable.CommandDescription;
import schemacrawler.tools.executable.SchemaCrawlerCommand;
import schemacrawler.tools.executable.commandline.PluginCommand;
import schemacrawler.tools.options.OutputOptions;

/**
 * SchemaCrawler command plug-in.
 *
 * <p>Implements an additional SchemaCrawler command, and plugs it into the SchemaCrawler
 * command-line.
 *
 * @see <a href="https://www.schemacrawler.com">SchemaCrawler</a>
 */
public class AdditionalCommandProvider extends BaseCommandProvider {

  public static final String HELP_HEADER = "Additional SchemaCrawler functionality";

  public AdditionalCommandProvider() {
    super(new CommandDescription(AdditionalCommand.COMMAND, HELP_HEADER));
  }

  @Override
  public PluginCommand getCommandLineCommand() {
    return PluginCommand.empty();
  }

  @Override
  public SchemaCrawlerCommand newSchemaCrawlerCommand(final String command) {
    if (!AdditionalCommand.COMMAND.equals(command)) {
      throw new IllegalArgumentException("Cannot support command, " + command);
    }
    return new AdditionalCommand();
  }

  @Override
  public boolean supportsOutputFormat(final String command, final OutputOptions outputOptions) {
    return true;
  }
}
