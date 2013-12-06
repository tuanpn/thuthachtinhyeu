package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class CarLong extends Car {

	private static final int WIDTH = LoadMap.static_car_long_width;
	private static final int HEIGHT = LoadMap.static_car_long_height;

	public CarLong(Vector2 position) {
		super("", position);

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

		velocity.x = 0;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;
	}

}
