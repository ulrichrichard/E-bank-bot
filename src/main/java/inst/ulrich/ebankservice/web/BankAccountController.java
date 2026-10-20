package inst.ulrich.ebankservice.web;

import inst.ulrich.ebankservice.entities.BankAccount;
import inst.ulrich.ebankservice.service.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccount> getAllAccounts() {
        return bankAccountService.getAllAccounts();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return bankAccountService.getBankAccountById(id);
    }

    @PostMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return bankAccountService.save(bankAccount);
    }
}
