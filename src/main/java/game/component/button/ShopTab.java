package game.component.button;

import game.component.Component;
import main.Display;

import java.awt.*;

public class ShopTab extends Component {


    public ShopTab(Rectangle rectangle) {
    super(rectangle);
    }
    public ShopTab() {

    }

    @Override
    public void onClick() {

    }

    @Override
    public Rectangle getRectangle() {
        return new Rectangle(Display.WIDTH - 100, 100, 200, 50);
    }
}
