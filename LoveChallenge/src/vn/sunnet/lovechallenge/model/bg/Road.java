package vn.sunnet.lovechallenge.model.bg;

import vn.sunnet.lovechallenge.controller.LoadMap;

public class Road extends Background {

	public Road(int id, int x, int y) {
		super(id, x, y, -LoadMap.player_velocity_x, 0, 877, 201);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (position.x < -width) {
			position.x += (width + width);
		}
	}
}
