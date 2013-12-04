package vn.sunnet.lovechallenge.model.bg;

public class Sky extends Background {

	private int count;

	public Sky(int id, int x, int y) {
		super(id, x, y, -50, 0, 1000, 400);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (repeat) {
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
