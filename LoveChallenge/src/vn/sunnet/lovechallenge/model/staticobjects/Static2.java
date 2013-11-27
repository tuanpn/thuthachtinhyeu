package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.Vector2;
/**
 * Đống lốp ô tô
 * @author PhamNgoc
 *
 */
public class Static2 extends Impediment {

	public static final int WIDTH = LoadMap.static_2_width;
	public static final int HEIGHT = LoadMap.static_2_height;
	public static final int VELOCITY_X = LoadMap.player_velocity_x;

	public Static2(Vector2 position) {
		super("static2", position);
		velocity.x = -VELOCITY_X;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}

}
