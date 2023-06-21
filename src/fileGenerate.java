import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class fileGenerate {

    public static void main(String[] args) throws Exception {
        ArrayList<TreeMap<String, String>> data = new ArrayList<>();

        File dataFile = new File("C:\\Users\\DELL\\Desktop\\Mesh.txt");
        try {
            Scanner sc = new Scanner(dataFile);
            while (sc.hasNext()) {
                String line = sc.nextLine();

                String[] split = line.split("\\s+");

                String key = split[0];
                String value = split[1];

                int count = 0;
                for (int i = 0; i < key.length(); i++) {
                    char ch = key.charAt(i);
                    if (ch == '.') {
                        count++;
                    }
                }

                if (count >= data.size()) {
                    TreeMap<String, String> tempMap = new TreeMap<>();
                    tempMap.put(key, value);
                    data.add(tempMap);
                } else {
                    TreeMap<String, String> existingMap = data.get(count);
                    existingMap.put(key, value);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Any Error occurred please check for file path...! "+e);
        }

        for (int i = 0; i < data.size(); i++) {
            String fileName = "File" + (i + 1) + ".txt";
            FileWriter writer = new FileWriter(fileName);

            TreeMap<String, String> printMap = data.get(i);
            for (Map.Entry<String, String> entry : printMap.entrySet()) {
                writer.write(entry.getKey() + "         " + entry.getValue() + "\n");
            }

            writer.close();
        }
    }
}
