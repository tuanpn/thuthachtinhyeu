package vn.sunnet.lovechallenge.model.staticobjects;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Impediment {

	protected Vector2 position;

	protected Vector2 velocity;

	protected Rectangle bounds;

	private String id;

	protected float damage;

	// có còn hiệu lực để xét va chạm hay không
	private boolean collisionPlayer = true;

	public Impediment(String id) {
		this(id, new Vector2());
	}

	public Impediment(String id, Vector2 positon) {
		this(id, positon, new Vector2());
	}

	public Impediment(String id, Vector2 positon, Vector2 velocity) {
		this(id, positon, new Vector2(), new Rectangle());
	}

	public Impediment(String id, Vector2 position, Vector2 velocity,
			Rectangle bounds) {
		this.id = id;
		this.position = position;
		this.velocity = velocity;
		this.bounds = bounds;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Rectangle getBounds() {
		return bounds;
	}

	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public boolean isCollisionPlayer() {
		return collisionPlayer;
	}

	public void setCollisionPlayer(boolean collisionPlayer) {
		this.collisionPlayer = collisionPlayer;
	}

	public void update(float delta) {
		position.add(velocity.x * delta, velocity.y * delta);
		bounds.x = position.x;
		bounds.y = position.y;
	}

}
