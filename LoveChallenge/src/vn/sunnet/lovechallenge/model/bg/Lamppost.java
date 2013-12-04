package vn.sunnet.lovechallenge.model.bg;

import vn.sunnet.lovechallenge.controller.LoadMap;

public class Lamppost extends Background {

	public static final int REPEAT = 3000;

	public Lamppost(int id, int x, int y) {
		super(id, x, y, -LoadMap.player_velocity_x, 0, 40, 222);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (position.x < -width) {
			position.x += REPEAT;
		}
	}

}
