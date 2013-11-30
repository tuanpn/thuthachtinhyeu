package vn.sunnet.lovechallenge.controller;

import vn.sunnet.lovechallenge.model.world.World;

public class WorldController {

	private World world;
	private PlayerController playerController;

	public WorldController(World world) {
		this.world = world;

		playerController = new PlayerController(world);
	}

	public void update(float delta) {
		playerController.update(delta);
		if (!world.isStop()) {
			world.update(delta);

			Collision.checkCollistion(world, world.getPlayer());
		}
	}

	public PlayerController getPlayerController() {
		return playerController;
	}

}
