import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RandomSymbolsFile12 {
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        File file = null;
        try {
            file = new File("src/main/java/data.xml");
            if (!file.createNewFile())
                System.out.println("File already exists");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fillFile(file);
        charactersCount(file);
        long after = System.currentTimeMillis();

        System.out.println((after - before) / Math.pow(10.0, 3.0) + " sec");
    }

    private static void fillFile(File file) {
        FileWriter fw;
        long n = 5500000L;
        try {
            fw = new FileWriter(file);
            BufferedWriter writer = new BufferedWriter(fw);
            char character;
            while (n > 0) {
                int rnd = (int) (Math.random() * 52);
                char base = (rnd < 26) ? 'A' : 'a';
                character = (char) (base + rnd % 26);
                writer.write(character);
                n--;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static Map<Character, Long> charactersCount(File file) {
        Map<Character, Long> map = new HashMap<>();
        try (FileReader fileReader = new FileReader(file.getPath())) {
            StreamTokenizer st = new StreamTokenizer(fileReader);
            st.resetSyntax();
            int token;
            char current;
            while ((token = st.nextToken()) != StreamTokenizer.TT_EOF) {
                current = (char) token;
                if (!Character.isLetter(current)) {
                    continue;
                }
                if (!map.containsKey(current)) {
                    map.put(current, 0L);
                }
                map.put(current, map.get(current) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}