package menu;

import service.HeaderScreen;
import service.Tool;

public class MenuScreen {
	public static void initialize(final Tool tool){
		HeaderScreen headerScreen=new HeaderScreen();
		headerScreen.getHeaderMenuScreen(tool);
		tool.getPanel().repaint();
	}
}
