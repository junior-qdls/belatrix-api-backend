package pe.com.moneyexchange.expose.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.moneyexchange.model.api.MoneyExchangeRequest;
import pe.com.moneyexchange.model.api.MoneyExchangeResponse;
import pe.com.moneyexchange.model.entity.MoneyExchange;
import pe.com.moneyexchange.service.MoneyExchangeService;

@RestController
@RequestMapping("/money-exchange")
public class MoneyExchangeController {


  private final MoneyExchangeService moneyExchangeService;


  @Autowired
  public MoneyExchangeController(MoneyExchangeService moneyExchangeService) {
    this.moneyExchangeService = moneyExchangeService;
  }


  @GetMapping(value = "/latest")
  public ResponseEntity<?> exchange(MoneyExchangeRequest moneyExchangeRequest) throws Exception {

    MoneyExchange exchange = moneyExchangeService.getExchange(moneyExchangeRequest.getBase(),
                                            moneyExchangeRequest.getSymbols());
    ;
    return ResponseEntity.ok(MoneyExchangeResponse.builder().base(exchange.getBase())
                                      .date(exchange.getDate())
                                      .rates(exchange.getRates()).build());

  }


}