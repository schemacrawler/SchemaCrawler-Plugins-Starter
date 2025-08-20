package com.example;

import schemacrawler.tools.databaseconnector.DatabaseConnector;
import us.fatehi.utility.datasource.DatabaseConnectionSourceBuilder;
import us.fatehi.utility.datasource.DatabaseServerType;

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
        () -> DatabaseConnectionSourceBuilder.builder("jdbc:newdb:${database}"));
  }
}
