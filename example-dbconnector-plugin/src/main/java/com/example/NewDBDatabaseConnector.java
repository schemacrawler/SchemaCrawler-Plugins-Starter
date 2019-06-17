package com.example;


import java.io.IOException;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import schemacrawler.schemacrawler.DatabaseServerType;
import schemacrawler.tools.databaseconnector.DatabaseConnector;
import schemacrawler.tools.iosource.ClasspathInputResource;

/**
 * SchemaCrawler database support plug-in.
 *
 * Plug-in to support a hypothetical RMDBS, NewDB.
 *
 * @see <a href="https://www.schemacrawler.com">SchemaCrawler</a>
 */
public final class NewDBDatabaseConnector
  extends DatabaseConnector
{

  private static final DatabaseServerType DB_SERVER_TYPE = new DatabaseServerType(
    "newdb",
    "NewDB");

  public NewDBDatabaseConnector()
    throws IOException
  {
    super(DB_SERVER_TYPE,
          new ClasspathInputResource("/schemacrawler-newdb.config.properties"),
          (informationSchemaViewsBuilder, connection) -> informationSchemaViewsBuilder
            .fromResourceFolder("/newdb.information_schema"));
  }

  @Override
  protected Predicate<String> supportsUrlPredicate()
  {
    return url -> Pattern.matches("jdbc:newdb:.*", url);
  }

}
