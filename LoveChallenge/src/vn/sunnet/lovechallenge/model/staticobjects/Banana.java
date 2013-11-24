package vn.sunnet.lovechallenge.model.staticobjects;

import vn.sunnet.lovechallenge.controller.LoadMap;

public class Banana extends Impediment {

	public static int BANANA_WIDTH = LoadMap.static_banana_width;
	public static int BANANA_HEIGHT = LoadMap.static_banana_height;

	public Banana(int id) {
		super("banana");
		bounds.width = BANANA_WIDTH;
		bounds.height = BANANA_HEIGHT;
	}

}
