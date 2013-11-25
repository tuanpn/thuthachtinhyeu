package vn.sunnet.lovechallenge.model.staticobjects;

import com.badlogic.gdx.math.Vector2;

import vn.sunnet.lovechallenge.controller.LoadMap;

public class Box1 extends Impediment {

	public static final int WIDTH = LoadMap.static_box1_width;
	public static final int HEIGHT = LoadMap.static_box1_height;
	public static final int VELOCITY_X = LoadMap.player_velocity_x;

	public Box1(Vector2 position) {
		super("box1", position);
		velocity.x = -VELOCITY_X;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}

}
