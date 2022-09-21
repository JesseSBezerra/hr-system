package br.com.jdsb.payrollapi.services;

import br.com.jdsb.payrollapi.domain.Payroll;
import br.com.jdsb.payrollapi.feingClients.UserFeign;
import br.com.jdsb.payrollapi.services.exceptions.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign feign;

    public Payroll getPayment(Long workerId,Payroll payment){
        log.info("PAYROLL_SERVICE ::: Get request on "+env.getProperty("local.server.port") + " port"
        );

        try{
           var user = feign.findById(workerId).getBody();
           if(Objects.nonNull(user)) {
               return new Payroll(user.getName(),
                       "Pagamento Janeiro 2022",
                       user.getHourlyPrice(),
                       payment.getWorkedHours(),
                       payment.getWorkedHours() * user.getHourlyPrice());
           }
        }catch (FeignException.NotFound ex){
             throw new ObjectNotFoundException("Object bot found");
        }catch (Exception ex){
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return null;
    }

}
