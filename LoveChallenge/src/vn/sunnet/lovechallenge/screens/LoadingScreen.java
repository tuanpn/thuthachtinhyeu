package vn.sunnet.lovechallenge.screens;

import vn.sunnet.lovechallenge.MainGame;
import vn.sunnet.lovechallenge.Resources;

public class LoadingScreen extends DefaultScreen {

	int nextScreen;
	int type;

	public LoadingScreen(MainGame game, int type) {
		super(game);
		this.type = type;
	}

	@Override
	public void show() {
		switch (type) {
		case 1:
			Resources.getInstance().loadGameScreen(game.getManager1(),
					game.getManager2());
			break;

		default:
			break;
		}
	}

	@Override
	public void update(float delta) {
		if (game.getManager1().update() && game.getManager2().update()) {
			switch (type) {
			case 1:
				Resources.getInstance().getGameScreen(game.getManager1(),
						game.getManager2());
				nextScreen = 1;
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void draw(float delta) {

	}

	@Override
	public void nextScreen(float delta) {
		switch (nextScreen) {
		case 1:
			dispose();
			game.setScreen(new GameScreen(game));
			break;

		default:
			break;
		}
	}

	@Override
	public void dispose() {

	}

}
