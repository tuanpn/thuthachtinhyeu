package vn.sunnet.lovechallenge.model.bg;

public class Background extends Entity {

	// lặp lại thì tăng vị trí lên
	protected boolean repeat;

	public Background(int id, int x, int y, int vx, int vy, float width,
			float height) {
		super(id, x, y, vx, vy, width, height);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (repeat) {
			position.x += (width + width);
			repeat = false;
		}
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

}
