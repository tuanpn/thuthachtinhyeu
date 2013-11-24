package vn.sunnet.lovechallenge.model.staticobjects;

import com.badlogic.gdx.math.Vector2;

import vn.sunnet.lovechallenge.controller.LoadMap;

public class Car extends Impediment {

	public static final int WIDTH = LoadMap.static_car_width;
	public static final int HEIGHT = LoadMap.static_car_height;
	public static final int VELOCITY_X = LoadMap.player_velocity_x;

	public Car() {
		this(new Vector2());
	}

	public Car(Vector2 position) {
		super("cargray", position);
		velocity.x = -VELOCITY_X;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

		String id = Math.random() < 0.5 ? "cargray" : "caryellow";
		setId(id);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	}

}
