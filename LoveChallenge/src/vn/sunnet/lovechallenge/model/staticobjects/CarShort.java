package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.Vector2;

public class CarShort extends Car {

	private static final int WIDTH = LoadMap.static_car_width;
	private static final int HEIGHT = LoadMap.static_car_height;

	public CarShort(Vector2 position) {
		super("", position);

		if (Math.random() < 0.5f) {
			setId("cargray");
		} else {
			setId("caryellow");
		}
		velocity.x = 0;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}

}
