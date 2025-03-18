/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game.buttons;

import game.component.Component;
import main.Display;

/**
 *
 * @author João Guilherme
 */
public class MenuButton extends Component {

    public MenuButton() {
        this.x = 0;
        this.y = 0;
        this.width = Display.WIDTH / 5;
        this.height = this.width / 2;
        addToComponentManager();
    }

   

}
