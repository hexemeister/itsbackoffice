package pt.itsector.itsbackoffice.itsbackoffice;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.OffsetDateTime;

import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import pt.itsector.itsbackoffice.controller.CannotChangeUsernameException;
import pt.itsector.itsbackoffice.controller.UtilizadorController;
import pt.itsector.itsbackoffice.model.Utilizador;
import pt.itsector.itsbackoffice.repository.UtilizadorRepository;
import pt.itsector.itsbackoffice.service.UtilizadorService;

@WebMvcTest(UtilizadorController.class)
public class UtilizadorControllerTest {

	@Autowired
	MockMvc mock;
	
	@Autowired
    ObjectMapper objectMapper;

    @MockBean
    UtilizadorService service;
    
    @Test
    void saveNewUtilizadorTest() throws Exception {

        Utilizador user = getValidUtilizador();
        String userJson = objectMapper.writeValueAsString(user);

        given(service.createUtilizador(any())).willReturn(getValidUtilizador());

        mock.perform(post("/v1/user/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson))
                .andExpect(status().isCreated());
    }
        
    private Utilizador getValidUtilizador(){
            return Utilizador.builder()
            		.id(1)
                    .nome("Renato")
                    .username("hexemeister")
                    .password("123")
                    .createTimestamp(OffsetDateTime.now())
                    .updateTimestamp(OffsetDateTime.now())
                    .build();
    }
    
}
