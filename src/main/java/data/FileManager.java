package data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileManager {

    public static HashMap<String, String> dataFileNames;
    public static final String GAME_FILES_PATH = System.getenv("LOCALAPPDATA")+"\\Clicker";
    public static final String ACHIEVEMENT_DATA_FILE_NAME = "\\achievement_data.json";
    public static final String GAME_DATA_FILE_NAME = "\\game_data.json";
    public static final String ENEMY_DATA_FILE_NAME = "\\enemy_data.json";
    public static final String ITEM_DATA_FILE_NAME = "\\item_data.json";
    public static final String ITEM_DATA_PATH = GAME_FILES_PATH + ITEM_DATA_FILE_NAME;
    public static final String GAME_DATA_PATH = GAME_FILES_PATH + GAME_DATA_FILE_NAME;
    public static final String ENEMY_DATA_PATH = GAME_FILES_PATH + ENEMY_DATA_FILE_NAME;
    public static final String ACHIEVEMENT_DATA_PATH = GAME_FILES_PATH + ACHIEVEMENT_DATA_FILE_NAME;
    

    public static void initializeDataFileNames() {
        dataFileNames.put("ACHIEVEMENT_DATA", ACHIEVEMENT_DATA_FILE_NAME);
        dataFileNames.put("GAME_DATA", GAME_DATA_FILE_NAME);
        dataFileNames.put("ENEMY_DATA", ENEMY_DATA_FILE_NAME);
        dataFileNames.put("ITEM_DATA", ITEM_DATA_FILE_NAME);
    }

    public static void makeDirectories() {
        File file = new File(GAME_FILES_PATH);
        if (!file.exists()) {
            System.out.println(GAME_FILES_PATH + "foi criado: "+file.mkdir());
        }
    }

    public static void makeFiles() {
        dataFileNames.forEach((key, value) -> {
            File file = new File(GAME_FILES_PATH+value);
            if (!file.exists()) {
                try {
                    System.out.println(file.getAbsolutePath()+" criado: "+file.createNewFile());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(key+" "+value);
        });
    }
}
