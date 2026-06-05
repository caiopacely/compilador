import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            scanner scanner = new scanner(reader);
            parser parser = new parser(scanner);

            System.out.println("=== CoachLang Interpreter ===");
            System.out.println("Digite seus comandos (termine com ';'). Use 'exit' para sair.");
            System.out.println();

            while (true) {
                System.out.print("> ");
                String line = reader.readLine();
                if (line == null || line.equalsIgnoreCase("exit")) break;

                String input = line.trim();
                if (input.isEmpty()) continue;

                int braceCount = countChar(input, '{') - countChar(input, '}');
                while (braceCount > 0) {
                    System.out.print("  ");
                    String nextLine = reader.readLine();
                    if (nextLine == null) break;
                    input += " " + nextLine.trim();
                    braceCount += countChar(nextLine, '{') - countChar(nextLine, '}');
                }

                scanner.yyreset(new StringReader(input));
                parser.parse();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
        }
        return count;
    }
}
