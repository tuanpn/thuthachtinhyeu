package vn.sunnet.lovechallenge.model.bg;

import com.badlogic.gdx.math.Vector2;

public class Background {

	private int id;

	private Vector2 position;

	private Vector2 velocity;

	public Background(int id) {
		this.id = id;
		velocity = new Vector2();
		position = new Vector2();
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

	public void update(float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
	}

}
