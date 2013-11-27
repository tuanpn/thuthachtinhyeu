package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.Vector2;
/**
 * Hình vành xe nằm ngang
 * @author PhamNgoc
 *
 */
public class Static3 extends Impediment {

	public static final int WIDTH = LoadMap.static_3_width;
	public static final int HEIGHT = LoadMap.static_3_height;
	public static final int VELOCITY_X = LoadMap.player_velocity_x;

	public Static3(Vector2 position) {
		super("static3", position);
		velocity.x = -VELOCITY_X;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}
	
}
