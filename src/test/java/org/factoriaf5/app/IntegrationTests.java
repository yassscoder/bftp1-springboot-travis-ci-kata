package org.factoriaf5.app;

import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IntegrationTests {

    @Autowired
    private MockMvc server;

    @Test
    // Este test comprueba que cuando hacemos una petición GET /hello
    // el servidor devuelve el JSON { "response": "hello to you" }
    void theServerSaysHello() throws Exception {

        server.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response", equalTo("hello to you")));

    }

    @Test
    // Este test comprueba que cuando hacemos una petición POST /hello
    // y enviamos en el body el JSON { "name": "pepe" }
    // el servidor responde con el JSON { "response": "hello, pepe" }
    void theServerRespondsToYourName() throws Exception {

        server.perform(post("/hello")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\": \"pepe\" }"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.response", equalTo("hello, pepe")));

    }



}
