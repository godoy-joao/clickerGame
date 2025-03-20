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
public abstract class Component extends Rectangle{
    
    private boolean enabled;

    public Component(Rectangle r) {
    this.x = r.x;
    this.y = r.y;
    this.height = r.height;
    this.width = r.width;
    }

    public Component() {

    }

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

    public abstract void onClick();

    public abstract Rectangle getRectangle();
   
}
