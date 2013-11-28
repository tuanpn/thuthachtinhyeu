package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CarLong extends Impediment {

	public static final int WIDTH = LoadMap.static_car_long_width;
	public static final int HEIGHT = LoadMap.static_car_long_height;
	public static final int VELOCITY_X = LoadMap.player_velocity_x;

	// kiem tra player co dc run hay ko
	private boolean playerRun;

	public CarLong() {
		this(new Vector2());
	}

	public CarLong(Vector2 position) {
		super("carlong1", position);
		velocity.x = -VELOCITY_X;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

		switch (MathUtils.random(0, 3)) {
		case 0:
			setId("carlong1");
			break;
		case 1:
			setId("carlong2");
			break;
		case 2:
			setId("carlong3");
			break;
		case 3:
			setId("carlong4");
			break;

		default:
			break;
		}
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	}

	public boolean isPlayerRun() {
		return playerRun;
	}

	public void setPlayerRun(boolean playerRun) {
		this.playerRun = playerRun;
	}

}
