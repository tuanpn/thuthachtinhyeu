package vn.sunnet.lovechallenge.model.bg;

import com.badlogic.gdx.math.Vector2;

public class Background {
	
	public static final float REPEAT = 1000;

	private int id;

	private Vector2 position;

	private Vector2 velocity;
	
	private float width;
	
	private float height;

	public Background(int id) {
		this(id, 0, 0);
	}

	public Background(int id, int x, int y) {
		this(id, x, y, 0, 0);
	}

	public Background(int id, int x, int y, int vx, int vy) {
		this.id = id;
		velocity = new Vector2(vx, vy);
		position = new Vector2(x, y);
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
	
	public void update(float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
		if(position.x < -width) {
			position.x += REPEAT;
		}
	}

}
