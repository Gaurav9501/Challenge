package Challenge.Challenge.Services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import Challenge.Challenge.entity.*;
import java.util.*;
@Service
public class FetchingData {

    @Autowired
    RestTemplate restTemplate;
    
    public  ResponseEntity<Recipie[]> getData(){
        String uri = "https://s3-ap-southeast-1.amazonaws.com/he-public-data/reciped9d7b8c.json";
        ResponseEntity<Recipie[]> responseEntity = restTemplate.getForEntity(uri, Recipie[].class);          
        return responseEntity;
    }
}
