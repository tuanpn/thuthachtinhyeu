package vn.sunnet.lovechallenge;

import vn.sunnet.lovechallenge.screens.LoadingScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.FPSLogger;

public class MainGame extends Game {

	private AssetManager manager1;
	private AssetManager manager2;
	
	FPSLogger fps;

	@Override
	public void create() {
		manager1 = new AssetManager();
		manager2 = new AssetManager();

		this.setScreen(new LoadingScreen(this, 1));
		fps = new FPSLogger();
	}
	
	@Override
	public void render() {
		super.render();
//		fps.log();
	}

	@Override
	public void dispose() {
		getScreen().dispose();
	}

	public AssetManager getManager1() {
		return manager1;
	}

	// public void setManager1(AssetManager manager1) {
	// this.manager1 = manager1;
	// }

	public AssetManager getManager2() {
		return manager2;
	}

	// public void setManager2(AssetManager manager2) {
	// this.manager2 = manager2;
	// }

}
