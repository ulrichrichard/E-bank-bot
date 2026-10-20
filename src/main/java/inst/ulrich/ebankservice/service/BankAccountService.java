package inst.ulrich.ebankservice.service;

import inst.ulrich.ebankservice.entities.BankAccount;
import inst.ulrich.ebankservice.repository.BankAccountRepository;
import org.springframework.ai.mcp.annotation.McpArg;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class BankAccountService {
    private BankAccountRepository bankAccountRepository;

    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @McpTool(description = "Get All Bank Accounts")
    public List<BankAccount> getAllAccounts() {
        return bankAccountRepository.findAll();
    }

    @McpTool(description = "Get Bank Account by Id")
    public BankAccount getBankAccountById(@McpArg(description = "the bank account Id") String id) {
        return bankAccountRepository.findById(id).orElseThrow(()->
                new RuntimeException("Account not found"));
    }

    @McpTool(description = "Add new Bank Account")
    public BankAccount save(@McpArg(description = "New Bank Account (id, createdAt, balance, type)") BankAccount bankAccount) {
        bankAccount.setCreatedAt(new Date());
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }
}
