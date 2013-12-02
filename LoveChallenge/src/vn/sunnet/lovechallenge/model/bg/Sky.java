package vn.sunnet.lovechallenge.model.bg;

public class Sky extends Background {
	
	public Sky(int id, int x, int y) {
		super(id, x, y, -50, 0, 877, 337);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (position.x < -width) {
			position.x += (width + width);
		}
	}

}
