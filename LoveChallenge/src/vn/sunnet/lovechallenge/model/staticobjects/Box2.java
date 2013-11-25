package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.Vector2;

public class Box2 extends Impediment {

	public static final int WIDTH = LoadMap.static_box2_width;
	public static final int HEIGHT = LoadMap.static_box2_height;
	public static final int VELOCITY_X = LoadMap.player_velocity_x;

	public Box2(Vector2 position) {
		super("box2", position);
		velocity.x = -VELOCITY_X;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}

}
