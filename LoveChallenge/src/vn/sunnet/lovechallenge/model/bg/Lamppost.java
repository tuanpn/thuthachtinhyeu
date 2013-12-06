package vn.sunnet.lovechallenge.model.bg;

public class Lamppost extends Background {

	public final int REPEAT = 3000;

	public Lamppost(int id, int x, int y) {
		super(id, x, y, 0, 0, 40, 222);
	}

	@Override
	public void update(float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
		if (repeat) {
			position.x += REPEAT;
			repeat = false;
		}
	}

}
