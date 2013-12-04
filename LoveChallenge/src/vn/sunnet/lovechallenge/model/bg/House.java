package vn.sunnet.lovechallenge.model.bg;

public class House extends Background {

	public House(int id, int x, int y, float width, float height) {
		super(id, x, y, 0, 0, width, height);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
		if (repeat) {
			position.x += (width + width);
			System.out.println("repeat");
			repeat = false;
		}
	}

}
