package vn.sunnet.lovechallenge.screens;

import vn.sunnet.lovechallenge.MainGame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.GLCommon;

public abstract class DefaultScreen implements Screen {

	protected MainGame game;

	public DefaultScreen(MainGame game) {
		this.game = game;
	}

	/**
	 * thực hiện update screen tại đây
	 * 
	 * @param delta
	 */
	public abstract void update(float delta);

	/**
	 * thực hiện draw screen tại đây
	 * 
	 * @param delta
	 */
	public abstract void draw(float delta);

	/**
	 * chuyển sang screen mới
	 * 
	 * @param delta
	 */
	public abstract void nextScreen(float delta);

	@Override
	public void render(float delta) {
		GLCommon gl = Gdx.gl;
		gl.glClearColor(0, 0, 0, 1);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		gl.glEnable(GL10.GL_BLEND);
		gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		update(delta);
		draw(delta);
		nextScreen(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	// public MainGame getGame() {
	// return game;
	// }
	//
	// public void setGame(MainGame game) {
	// this.game = game;
	// }

}
