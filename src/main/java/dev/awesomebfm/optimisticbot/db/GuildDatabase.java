package dev.awesomebfm.optimisticbot.db;

import dev.awesomebfm.optimisticbot.OptimisticBot;
import dev.awesomebfm.optimisticbot.models.GuildData;

import java.sql.*;

public class GuildDatabase {

    public OptimisticBot bot;

    public GuildDatabase(OptimisticBot bot) {
        this.bot = bot;
    }

    private Connection connection;

    public Connection getConnection() throws SQLException {

        if (connection != null) {
            return connection;
        }

        String url = "";
        String user = "";
        String password = "";

        Connection connection = DriverManager.getConnection(url, user, password);

        this.connection = connection;

        System.out.println("Connected to database!");

        return connection;
    }

    public void initializeDatabase() throws SQLException {

        Statement statement = getConnection().createStatement();

        //Create the doge_deathbans
        String sql = "CREATE TABLE IF NOT EXISTS guild_data (id varchar(18) primary key, count string)";

        statement.execute(sql);

        statement.close();

    }

    public GuildData findGuildDataByID(String id) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM guild_data WHERE id = ?");

        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();

        GuildData guildData;

        if (resultSet.next()) {

            guildData = new GuildData(resultSet.getString("id"), resultSet.getInt("count"));

            statement.close();

            return guildData;

        }

        return null;
    }

    public void createGuildData(GuildData guildData) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("INSERT INTO guild_data (id, count) VALUES (?, ?)");

        statement.setString(1, guildData.getGuildID());
        statement.setInt(2, guildData.getCount());

        statement.executeUpdate();

        statement.close();

    }

    public void updateGuildData(GuildData guildData) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("UPDATE guild_data SET count = ? WHERE id = ?");

        statement.setInt(1, guildData.getCount());
        statement.setString(2, guildData.getGuildID());

        statement.executeUpdate();

        statement.close();

    }

    public void deleteGuildData(GuildData guildData) throws SQLException {

        PreparedStatement statement = getConnection().prepareStatement("DELETE FROM guild_data WHERE id = ?");

        statement.setString(1, guildData.getGuildID());

        statement.executeUpdate();

        statement.close();

    }

}
