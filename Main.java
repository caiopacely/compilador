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

                while (braceCount > 0 || !isComplete(input)) {
                    System.out.print("  ");
                    String nextLine = reader.readLine();
                    if (nextLine == null) break;
                    input += " " + nextLine.trim();
                    braceCount += countChar(nextLine, '{') - countChar(nextLine, '}');
                }

                // If we parsed an if-statement ending with }, check if else follows
                while (input.contains("se_acreditar")
                       && !input.contains("se_desistir")
                       && braceCount == 0
                       && isComplete(input)) {
                    reader.mark(512);
                    String nextLine = reader.readLine();
                    if (nextLine != null && nextLine.trim().startsWith("se_desistir")) {
                        System.out.print("  ");
                        input += " " + nextLine.trim();
                        braceCount += countChar(nextLine, '{') - countChar(nextLine, '}');
                        while (braceCount > 0 || !isComplete(input)) {
                            System.out.print("  ");
                            nextLine = reader.readLine();
                            if (nextLine == null) break;
                            input += " " + nextLine.trim();
                            braceCount += countChar(nextLine, '{') - countChar(nextLine, '}');
                        }
                    } else {
                        reader.reset();
                        break;
                    }
                }

                scanner.yyreset(new StringReader(input));
                parser.parse();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isComplete(String s) {
        String t = s.trim();
        return t.endsWith(";") || t.endsWith("}");
    }

    private static int countChar(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
        }
        return count;
    }
}
