package vn.sunnet.lovechallenge.controller;

import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.staticobjects.Car;
import vn.sunnet.lovechallenge.model.staticobjects.CarLong;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;

public class Collision {

	public static void checkCollistion(World world, Player player) {
		for (Impediment impediment : world.getStaticObjects()) {
			if (player.getBounds().overlaps(impediment.getBounds())
					&& impediment.isCollisionPlayer()) {
				if ((impediment instanceof CarLong)
						&& (player.getBounds().y + 10 >= impediment.getBounds().height
								+ impediment.getPosition().y)) {
					player.getBounds().width = player.WIDTH_RUN;
					player.getBounds().height = player.HEIGHT_RUN;
					player.getAccelation().y = 0;
					player.getVeloctity().y = 0;
					player.getPosition().y = impediment.getBounds().height
							+ impediment.getPosition().y;
					player.setStateTimeJump1(0);
					player.setColistionState(2);
				} else {
					player.setColistionState(1);
				}

				impediment.setCollisionPlayer(false);
			}
		}
	}
}
