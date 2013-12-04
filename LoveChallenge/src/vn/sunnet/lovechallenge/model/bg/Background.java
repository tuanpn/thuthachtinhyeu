package vn.sunnet.lovechallenge.model.bg;

import com.badlogic.gdx.math.Vector2;

public class Background {

	protected int id;

	protected Vector2 position;

	protected Vector2 velocity;

	protected float width;

	protected float height;
	// lặp lại thì tăng vị trí lên
	protected boolean repeat;

	public Background(int id) {
		this(id, 0, 0);
	}

	public Background(int id, int x, int y) {
		this(id, x, y, 0, 0);
	}

	public Background(int id, int x, int y, int vx, int vy) {
		this(id, x, y, vx, vy, 0, 0);
	}

	public Background(int id, int x, int y, int vx, int vy, float width,
			float height) {
		this.id = id;
		velocity = new Vector2(vx, vy);
		position = new Vector2(x, y);
		this.width = width;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public boolean isRepeat() {
		return repeat;
	}

	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	public void update(float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
	}

}
