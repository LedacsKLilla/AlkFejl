package hu.elte.fridgemanager;



//import hu.elte.fridgemanager.entities.Recipe; does not recognise it???
import hu.elte.fridgemanager.entities.User; 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

/**
 *
 * @author Ruu
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FridgeManagerTests {
     @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getTokenForUser(String username, String password) throws Exception {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        
        ResponseEntity<String> responseAuth = restTemplate.postForEntity("/api/auth", user, String.class);
        String jsonString = responseAuth.getBody();
        JSONObject json2 = new JSONObject(jsonString);
        return json2.getString("token");
    }
    
    private HttpEntity getRequestEntityForUser(String username, String password) throws Exception {
        String token = getTokenForUser(username, password);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie", "token=" + token);
//        headers.add("Authorization", "Bearer " + token);
        return new HttpEntity(null, headers);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        System.out.println("Test 1");
        HttpEntity requestEntity = getRequestEntityForUser("user", "user");
        ResponseEntity<String> response = restTemplate.exchange(
                "http://localhost:" + port + "/hello",
                HttpMethod.GET,
                requestEntity,
                String.class
        );
        
        assertThat(response.getBody()).contains("world");
    }
    
    
}