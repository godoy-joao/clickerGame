/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import game.component.button.shopTab.ShopTab;
import main.UtilityTool;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * @author João Guilherme
 */
public class ComponentManager {

    public static List<Component> gameComponents;

    public static Component checkIfComponentWasClicked(Point mousePos) {
        Component comp = null;
        for (Component c : gameComponents) {
            if (c.contains(mousePos)) comp = c;
        }
        return comp;
    }

    public static void addComponents() {
        gameComponents = new ArrayList<>();
        UtilityTool uTool = new UtilityTool();
        BufferedImage bi = uTool.getImage("/layout/heroShopOpen.png");
        ShopTab st = new ShopTab(new ShopTab().getRectangle(), bi);
        st.addToComponentManager();
        System.out.println(st.getBounds());
    }

    public static void drawComponents(Graphics2D g) {
        for (Component c : gameComponents) {
            if (c.getSprite() != null) {
                g.drawImage(c.getSprite(), c.x, c.y, c.width, c.height, null);
            } else {
                g.draw(c.getRectangle());
            }
        }
    }
}
