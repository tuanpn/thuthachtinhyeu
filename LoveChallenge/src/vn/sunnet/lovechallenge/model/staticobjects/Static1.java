package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

import com.badlogic.gdx.math.Vector2;

/**
 * hình hốc cống
 * 
 * @author PhamNgoc
 * 
 */
public class Static1 extends Impediment {

	public static final int WIDTH = LoadMap.static_1_width;
	public static final int HEIGHT = LoadMap.static_1_height;

	public Static1(Vector2 position) {
		super("static1", position);
		velocity.x = 0;
		velocity.y = 0;
		bounds.width = WIDTH;
		bounds.height = HEIGHT;

	}

}
