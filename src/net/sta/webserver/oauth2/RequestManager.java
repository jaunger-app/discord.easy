package net.sta.webserver.oauth2;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.sta.Debugging;
import org.jetbrains.annotations.NotNull;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class RequestManager implements Debugging {

    private String clientId = "";
    private String clientSecret = "";
    private String redirectUri = ""; //Callback-URL
    private final ArrayList<String> userData = new ArrayList<>();
    public RequestManager(String clientId, String clientSecret, String redirectUri){
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.redirectUri = redirectUri;
    }
    protected static JsonObject getToken(@NotNull HttpsURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            return JsonParser.parseString(line).getAsJsonObject();
        }
        return null;
    }
    protected static String getUserData(@NotNull JsonObject responseToken) throws IOException  {
        try {
            HttpsURLConnection userConnection = (HttpsURLConnection) new URI("https://discord.com/api/v10/users/@me").toURL().openConnection();
            userConnection.setRequestProperty("Authorization", "Bearer " + responseToken.get("access_token").getAsString());

            if (userConnection.getResponseCode() == 200) {
                return new BufferedReader(new InputStreamReader(userConnection.getInputStream())).readLine();
            }
            return null;
        }catch (URISyntaxException e) {/*Error catching*/}
        return null;
    }
    protected HttpsURLConnection tokenTausch(@NotNull String authorizationCode) throws IOException {
        try {
            HttpsURLConnection connection = (HttpsURLConnection) new URI("https://discord.com/api/oauth2/token").toURL().openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setDoOutput(true);
            String data = "client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=authorization_code&code=" + authorizationCode + "&redirect_uri=" + redirectUri;
            connection.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
            return connection;
        }catch (URISyntaxException e){/*Error catching*/}
        return null;
    }
}
