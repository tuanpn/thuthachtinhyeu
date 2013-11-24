package vn.sunnet.lovechallenge.model;

import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.staticobjects.Car;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class World {

	private Player player;

	// static object
	private Array<Impediment> staticObjects;

	public Array<Impediment> getStaticObjects() {
		return staticObjects;
	}

	public void setStaticObjects(Array<Impediment> staticObjects) {
		this.staticObjects = staticObjects;
	}

	private float stateTimeObject;
	private float timeCreate = 3;

	public Player getPlayer() {
		return player;
	}

	public World() {
		player = new Player(0);

		staticObjects = new Array<Impediment>();
	}

	public void update(float delta) {
		player.update(delta);

		createObject(delta);
	}

	// sinh ra các chướng ngại vật
	private void createObject(float delta) {
		stateTimeObject += delta;

		if (stateTimeObject > timeCreate) {
			stateTimeObject = 0;
			timeCreate = MathUtils.random(3.f, 5.f);
			staticObjects.add(new Car(new Vector2(
					player.getPosition().x + 1024, 20)));
		}

		for (Impediment impediment : staticObjects) {
			impediment.update(delta);
			if (impediment.getPosition().x < -impediment.getBounds().width - 100) {
				staticObjects.removeValue(impediment, true);
				break;
			}
		}

	}

}
