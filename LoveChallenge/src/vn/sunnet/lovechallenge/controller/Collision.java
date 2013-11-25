package vn.sunnet.lovechallenge.controller;

import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;

public class Collision {

	public static void checkCollistion(World world, Player player) {
		for (Impediment impediment : world.getStaticObjects()) {
			if (player.getBounds().overlaps(impediment.getBounds())
					&& impediment.isCollisionPlayer()) {
				player.setPercentageStateBar(player.getPercentageStateBar() - 10);
				player.setColistionState(1);
				impediment.setCollisionPlayer(false);
			}
		}
	}
}
