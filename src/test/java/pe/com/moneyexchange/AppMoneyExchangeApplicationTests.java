package pe.com.moneyexchange;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pe.com.moneyexchange.expose.web.MoneyExchangeController;
import pe.com.moneyexchange.model.api.LoginRequest;
import pe.com.moneyexchange.model.api.MoneyExchangeRequest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppMoneyExchangeApplicationTests {

  @Autowired
  private MockMvc mockMvc;


  @Test
  public void shouldLogOk() throws Exception {
    LoginRequest request = new LoginRequest();

    request.setPassword("demo");
    request.setUsername("demo");

    this.mockMvc.perform(post("/login")
                                      .contentType(MediaType.APPLICATION_JSON)
                                      .content(asJsonString(request)))
                        .andDo(print()).andExpect(status().isAccepted());
  }


  @Test
  public void shouldBeBadCredentials() throws Exception {

    LoginRequest request = new LoginRequest();

    request.setPassword("demo");
    request.setUsername("xxx");

    this.mockMvc.perform(post("/login")
      .contentType(MediaType.APPLICATION_JSON)
      .content(asJsonString(request)))
      .andDo(print()).andExpect(status().isUnauthorized());

  }

  @Test
  public void shouldReturnExchange() throws Exception {

    this.mockMvc.perform(get("/money-exchange/latest?base=USD&symbols=EUR"))
                                      .andDo(print()).andExpect(status().is(200));

  }

  @Test
  public void shouldRturnResourceNotFound() throws Exception {

    this.mockMvc.perform(get("/money-exchange/latest?base=XXX&symbols=EUR"))
      .andDo(print()).andExpect(status().isNotFound());

  }




  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
