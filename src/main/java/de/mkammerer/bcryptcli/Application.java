package de.mkammerer.bcryptcli;

import org.mindrot.jbcrypt.BCrypt;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {
    private static final String STD_IN = "-";
    private static final String DEFAULT_PASSWORD = STD_IN;
    private static final int DEFAULT_ROUNDS = 12;

    public static void main(String[] args) {
        // bcrypt-cli [password] [rounds]

        String password = DEFAULT_PASSWORD;
        int rounds = DEFAULT_ROUNDS;

        if (args.length > 0) {
            password = args[0];
        }
        password = getPassword(password);

        if (args.length > 1) {
            rounds = Integer.parseInt(args[1]);
        }

        String salt = BCrypt.gensalt(rounds);
        String hash = BCrypt.hashpw(password, salt);

        System.out.println(hash);
    }

    private static String getPassword(String input) {
        if (!input.equals(STD_IN)) {
            return input;
        }

        System.out.print("Enter password: ");
        // Read from stdin
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
        String line = null;
        while (line == null) {
            line = scanner.nextLine();
        }

        return line;
    }
}
