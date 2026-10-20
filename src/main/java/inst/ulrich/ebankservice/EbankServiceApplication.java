package inst.ulrich.ebankservice;

import inst.ulrich.ebankservice.entities.BankAccount;
import inst.ulrich.ebankservice.service.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountService bankAccountService) {
        return args -> {
            for (int i = 0; i < 10; i++) {
                BankAccount bankAccount = BankAccount.builder()
                        .balance(1000 + Math.random() * 6098765)
                        .type(Math.random() > 0.5 ? "CURRENT-ACCOUNT" : "SAVING-ACCOUNT")
                        .build();
                bankAccountService.save(bankAccount);
            }
        };
    }
}
