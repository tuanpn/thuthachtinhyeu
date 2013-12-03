package vn.sunnet.lovechallenge.model.bg;

import vn.sunnet.lovechallenge.controller.LoadMap;

public class House extends Background {

	public static final float REPEAD = 2000;

	public House(int id, int x, int y, float width, float height) {
		super(id, x, y, -LoadMap.player_velocity_x, 0, width, height);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (position.x < -width) {
			position.x += REPEAD;
		}
	}

}
