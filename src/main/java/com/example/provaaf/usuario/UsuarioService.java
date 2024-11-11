package com.example.provaaf.usuario;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UsuarioService {

    public String pegaPapel(String jwtToken){
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", jwtToken);

            HttpEntity<String> entity = new HttpEntity<>(headers);

            try {

                ResponseEntity<Usuario> response = restTemplate.exchange(
                        "http://184.72.80.215/usuario/validate",
                        HttpMethod.GET,
                        entity,
                        Usuario.class
                );
                return response.getBody().getPapel();
            }
            catch (Exception e) {
                return "none";
            }
        }
}
