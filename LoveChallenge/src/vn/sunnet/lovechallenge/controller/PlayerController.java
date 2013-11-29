package vn.sunnet.lovechallenge.controller;

import java.util.HashMap;
import java.util.Map;

import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.staticobjects.CarLong;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;

public class PlayerController {

	enum Keys {
		FLINGUP, FLINGDOWN
	}

	static Map<Keys, Boolean> keys = new HashMap<PlayerController.Keys, Boolean>();
	static {
		keys.put(Keys.FLINGUP, false);
		keys.put(Keys.FLINGDOWN, false);
	};

	public void flingupPressed() {
		keys.get(keys.put(Keys.FLINGUP, true));
	}

	public void flingupReleased() {
		keys.get(keys.put(Keys.FLINGUP, false));
	}

	public void flingdownPressed() {
		keys.get(keys.put(Keys.FLINGDOWN, true));
	}

	public void flingdownReleased() {
		keys.get(keys.put(Keys.FLINGDOWN, false));
	}

	private World world;
	private Player player;

	public PlayerController(World world) {
		this.world = world;
		player = world.getPlayer();
	}

	public void update(float delta) {
		processInput(delta);

		for (Impediment impediment : world.getStaticObjects()) {
			if (impediment instanceof CarLong) {
				if ((impediment.getBounds().width + impediment.getBounds().x < player
						.getBounds().x + player.getBounds().width)
						&& ((CarLong) impediment).isPlayerRun()) {
					((CarLong) impediment).setPlayerRun(false);
					player.setFlingAuto(true);
					// System.out.println("FlingAuto");
				}
			}
		}

		// player action
		player.flingup();
		player.flingdown();
		player.collistionImpedimet();
		player.backRun();
		player.jumpHighOnCar();
		player.jumpAutoCarToRoad();
	
		player.update(delta);
	}

	private void processInput(float delta) {
		if (keys.get(Keys.FLINGUP)) {
			player.setFlingUp(true);
			flingupReleased();
		} else if (keys.get(Keys.FLINGDOWN)) {
			player.setFlingDown(true);
			flingdownReleased();
		}
	}

}
