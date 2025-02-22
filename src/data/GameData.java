/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import controls.Controller;
import entity.Enemy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import main.UtilityTool;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author João Guilherme
 */
public class GameData {

    private static int level;
    private static LocalDateTime gameTime;
    private static long totalGameSeconds = 0;
    public static final String gameDataFileName = "gamedata.json";
    public static final DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static int getLevel() {
        return level;
    }

    public static void nextLevel() {
        level++;
        saveData();
    }

    public static void setLevel(int newLevel) {
        level = newLevel;
    }

    public static List<Item> getItems() {
        List<Item> playerItems = new ArrayList();

        return playerItems;
    }

    public static long getTotalElapsedSeconds() {
        return totalGameSeconds;
    }

    public static LocalDateTime getLastTime() {
        return gameTime;
    }

    public static LocalDateTime updateGameTime() {
        gameTime = LocalDateTime.now();
        return gameTime;
    }

    public static void tickSeconds() {
        totalGameSeconds++;
    }

    public static JSONObject checkSave() {
        JSONObject json = UtilityTool.fileToJson(GameData.gameDataFileName);
        return json;
    }

    public static void loadData() {
        JSONObject json = UtilityTool.fileToJson(gameDataFileName);
        level = Integer.parseInt(json.get("level").toString());
        gameTime = (LocalDateTime) LocalDateTime.parse((String) json.get("lastTime"), format);
        totalGameSeconds = (long) json.get("totalGameSeconds");
        Controller.currentEnemy = new Enemy((String) json.get("currentEnemy"));
    }

    public static void saveData() {
        JSONObject json = UtilityTool.fileToJson(gameDataFileName);
        JSONObject gameData = (JSONObject) json.get("gameData");
        gameData.replace("level", getLevel());
        gameData.replace("lastTime", updateGameTime().format(format));
        gameData.replace("currentEnemy", Controller.currentEnemy.getName());
        gameData.replace("totalGameSeconds", getTotalElapsedSeconds());
        JSONObject saveFile = new JSONObject();
        saveFile.put("gameData", gameData);
        UtilityTool.createFile(gameDataFileName, saveFile.toJSONString());
    }

}
