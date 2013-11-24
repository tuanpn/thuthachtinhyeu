package vn.sunnet.lovechallenge.screens;

import vn.sunnet.lovechallenge.MainGame;
import vn.sunnet.lovechallenge.controller.LoadMap;
import vn.sunnet.lovechallenge.controller.WorldController;
import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.view.WorldRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class GameScreen extends DefaultScreen implements InputProcessor {

	World world;
	WorldController controller;
	WorldRenderer renderer;
	GestureController gestureController;

	public GameScreen(MainGame game) {
		super(game);

		gestureController = new GestureController();
		GestureDetector gestureDetector = new GestureDetector(gestureController);
		InputMultiplexer input = new InputMultiplexer();
		input.addProcessor(this);
		input.addProcessor(gestureDetector);
		Gdx.input.setInputProcessor(input);
	}

	@Override
	public void show() {
		LoadMap.loadMapPlayer();
		LoadMap.loadMapStatic();

		world = new World();
		controller = new WorldController(world);
		renderer = new WorldRenderer(world, true);
	}

	@Override
	public void update(float delta) {
		delta = Math.min(0.06f, delta);
		controller.update(delta);
	}

	@Override
	public void draw(float delta) {
		renderer.render(delta);
	}

	@Override
	public void nextScreen(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean keyDown(int keycode) {
		// if (keycode == Keys.RIGHT)
		// controller.getPlayerController().runPressed();
		// else

		// controller.getPlayerController().stopPressed();
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// if (keycode == Keys.RIGHT)
		// controller.getPlayerController().runReleased();
		// else
		// controller.getPlayerController().stopReleased();
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	class GestureController implements GestureListener {

		@Override
		public boolean touchDown(float x, float y, int pointer, int button) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean tap(float x, float y, int count, int button) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean longPress(float x, float y) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean fling(float velocityX, float velocityY, int button) {
			if (velocityY < 0) {
				controller.getPlayerController().flingupPressed();
			} else {
				controller.getPlayerController().flingdownPressed();
			}
			return false;
		}

		@Override
		public boolean pan(float x, float y, float deltaX, float deltaY) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean panStop(float x, float y, int pointer, int button) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean zoom(float initialDistance, float distance) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,
				Vector2 pointer1, Vector2 pointer2) {
			// TODO Auto-generated method stub
			return false;
		}

	}

}
