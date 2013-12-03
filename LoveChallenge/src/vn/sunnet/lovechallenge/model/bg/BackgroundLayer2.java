package vn.sunnet.lovechallenge.model.bg;

public class BackgroundLayer2 extends Background {

	public BackgroundLayer2(int id, int x, int y) {
		super(id, x, y, -50, 0, 843, 233);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (position.x < -width) {
			position.x += (width + width);
		}
	}

}
