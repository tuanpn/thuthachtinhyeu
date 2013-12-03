package vn.sunnet.lovechallenge.model.bg;

public class Sky extends Background {

	private int count;

	public Sky(int id, int x, int y) {
		super(id, x, y, -250, 0, 877, 337);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (position.x < -width) {
			position.x += (width + width);
			setCount(getCount() + 2);
		}
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
