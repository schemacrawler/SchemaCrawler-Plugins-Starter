package com.example;

import java.io.IOException;
import schemacrawler.schemacrawler.DatabaseServerType;
import schemacrawler.tools.databaseconnector.DatabaseConnectionUrlBuilder;
import schemacrawler.tools.databaseconnector.DatabaseConnector;

/**
 * SchemaCrawler database support plug-in.
 *
 * <p>Plug-in to support a hypothetical RMDBS, NewDB.
 *
 * @see <a href="https://www.schemacrawler.com">SchemaCrawler</a>
 */
public final class NewDBDatabaseConnector extends DatabaseConnector {

  public NewDBDatabaseConnector() {
    super(
        new DatabaseServerType("newdb", "NewDB"),
        url -> url != null && url.startsWith("jdbc:newdb:"),
        (informationSchemaViewsBuilder, connection) ->
            informationSchemaViewsBuilder.fromResourceFolder("/newdb.information_schema"),
        (schemaRetrievalOptionsBuilder, connection) -> {},
        (limitOptionsBuilder) -> {},
        () -> DatabaseConnectionUrlBuilder.builder("jdbc:newdb:${database}"));
  }
}
