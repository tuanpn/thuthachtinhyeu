package vn.sunnet.lovechallenge;

import java.io.IOException;

import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class DesktopGame {

	public static void main(String[] args) throws IOException {
		Settings settings = new Settings();
		settings.maxWidth = 1024;
		settings.maxHeight = 1024;
		settings.filterMin = TextureFilter.Linear;
		settings.filterMag = TextureFilter.Linear;
		TexturePacker2.process(settings, "images/staticobject",
				"game-android/assets/staticobject", "staticobject");

		// new LwjglApplication(new Game(), "Game", 320, 480, false);
	}

}