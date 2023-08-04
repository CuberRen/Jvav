package res;

import java.awt.Image;
import java.awt.Toolkit;

public class GetRes {
	public static Image icon = Toolkit.getDefaultToolkit().getImage(GetRes.class.getResource("/res/icon.jpg"));
	public static Image adImage = Toolkit.getDefaultToolkit().getImage(GetRes.class.getResource("/res/ad-by-toliet.png"));
}
