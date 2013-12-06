package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.Vector2;

/**
 * Hình rào cản
 * 
 * @author PhamNgoc
 * 
 */
public class Static4 extends Impediment {

	public static final int WIDTH = LoadMap.static_4_width;
	public static final int HEIGHT = LoadMap.static_4_height;

	public Static4(Vector2 position) {
		super("static4", position);
		velocity.x = 0;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}

}
