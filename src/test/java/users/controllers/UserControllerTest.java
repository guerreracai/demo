package users.controllers;

import com.example.users.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.web.servlet.MockMvc;
import users.models.UserModel;

import javax.sql.DataSource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @SneakyThrows
    @Test
    void saveUser() {
        UserModel user = new UserModel();
        user.setEmail("eidelmatoscarpio@gmail.com");
        user.setFirstname("Eidel");
        user.setLastname("Matos");
        user.setPhone("5082463079");
        user.setToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNzA0NjAzNjA3LCJleHAiOjE3MDU0Njc2MDd9.uq-_kvwvd_rNL_zpkKahKu3Ox9aCjDFBmMscCdMsR7QCNkLjkGPH2BOF7yIMcfSYry1vuPND18EV1q5yfgRH6w\"");
        user.setId((long) 10);
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
        ).andExpect(status().isOk() );
    }
    @SneakyThrows
    @Test
    void updateUser(){
        UserModel user = new UserModel();
        user.setFirstname("Eidel");
        user.setLastname("Carpio");
        user.setPhone("5082463079");
        user.setId((long) 1);
        ObjectMapper objectMapper = new ObjectMapper();
        this.mockMvc.perform(put("/api/users").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user))
        ).andExpect(status().isOk() );

    }



    @SneakyThrows
    @Test
    void getUser(){
        this.mockMvc.perform(get("/api/users?id=1").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());
    }



    @SneakyThrows
    @Test
    void deleteUser(){
        this.mockMvc.perform(delete("/api/users?id=1").contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isNonAuthoritativeInformation())  ;
    }

}
