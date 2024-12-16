package com.example;

import schemacrawler.tools.executable.BaseCommandProvider;
import schemacrawler.tools.executable.commandline.PluginCommand;
import schemacrawler.tools.options.Config;
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

  public AdditionalCommandProvider() {
    super(AdditionalCommand.COMMAND);
  }

  @Override
  public PluginCommand getCommandLineCommand() {
    return PluginCommand.empty();
  }

  @Override
  public AdditionalCommand newSchemaCrawlerCommand(final String command, final Config config) {
    if (!supportsCommand(command)) {
      throw new IllegalArgumentException("Cannot support command, " + command);
    }
    final AdditionalCommand scCommand = new AdditionalCommand();
    scCommand.configure(new AdditionalCommandOptions());
    return scCommand;
  }

  @Override
  public boolean supportsOutputFormat(final String command, final OutputOptions outputOptions) {
    return true;
  }
}
