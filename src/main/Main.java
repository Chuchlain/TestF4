package main;

import managegui.GuiControl;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) {
		GuiControl guiControl = new GuiControl("TestF4");

		try {
			AppGameContainer app = new AppGameContainer(guiControl);
			app.setDisplayMode(1400, 1000, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
        }

	}

}
