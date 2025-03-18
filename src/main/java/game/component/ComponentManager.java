/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import java.awt.*;
import java.util.List;

/**
 *
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
}
