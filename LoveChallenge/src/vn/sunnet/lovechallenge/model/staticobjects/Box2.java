package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.Vector2;

public class Box2 extends Impediment {

	public static final int WIDTH = LoadMap.static_box2_width;
	public static final int HEIGHT = LoadMap.static_box2_height;

	public Box2(Vector2 position) {
		super("box2", position);
		velocity.x = 0;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}

}
