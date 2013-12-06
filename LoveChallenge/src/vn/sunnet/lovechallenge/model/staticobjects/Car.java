package vn.sunnet.lovechallenge.model.staticobjects;

import com.badlogic.gdx.math.Vector2;

public abstract class Car extends Impediment {

	private boolean playerRun;

	public Car(String id) {
		this(id, new Vector2());
	}

	public Car(String id, Vector2 position) {
		super("id", position);
	}

	@Override
	public void update(float delta) {
		super.update(delta);
	}

	public void setPlayerRun(boolean playerRun) {
		this.playerRun = playerRun;
	}

	public boolean isPlayerRun() {
		return playerRun;
	}

}
