package BankAccount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, BankAccount> bankAccountMap = new HashMap<>();
        String input = "";

        while (!"End".equalsIgnoreCase(input = reader.readLine())) {
            String[] split = input.split("\\s+");
            if (split.length == 1) {
                BankAccount bankAccount = new BankAccount();
                bankAccountMap.put(bankAccount.getId(), bankAccount);
                System.out.println(String.format("Account ID%d created", bankAccount.getId()));
            } else if (split.length == 2) {
                double rate = Double.parseDouble(split[1]);
                BankAccount.setInterestRate(rate);
            } else if (split.length == 3) {
                int id = Integer.parseInt(split[1]);
                if (!bankAccountMap.containsKey(id)) {
                    System.out.println("Account does not exist");
                } else {
                    BankAccount bk1 = bankAccountMap.get(id);
                    if ("Deposit".equalsIgnoreCase(split[0])) {
                        double amount = Double.parseDouble(split[2]);
                        bk1.deposit(amount);
                        System.out.println(String.format("Deposited %.0f to ID%d", amount, id));
                    } else {
                        int years = Integer.parseInt(split[2]);
                        System.out.println(String.format("%.2f", bk1.getInterestRate(years)));
                    }
                }


            }
        }

    }
}
