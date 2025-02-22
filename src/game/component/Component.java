/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.component;

import java.awt.Rectangle;

/**
 *
 * @author João Guilherme
 */
public class Component extends Rectangle{
    
    private boolean enabled;
    
    public void addToComponentManager() {
        ComponentManager.gameComponents.add(this);
    }
    
    public void enable() {
        this.enabled = true;
    }
    
    public void disable() {
        this.enabled = false;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
   
}
