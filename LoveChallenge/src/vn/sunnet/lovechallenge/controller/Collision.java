package vn.sunnet.lovechallenge.controller;

import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.staticobjects.CarLong;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;

public class Collision {

	public static void checkCollistion(World world, Player player) {
		for (Impediment impediment : world.getStaticObjects()) {
			if (impediment instanceof CarLong) {
				if (player.getBounds().x + player.getBounds().width > impediment
						.getBounds().x && impediment.isCollisionPlayer()) {
					if (player.getPosition().y > impediment.getPosition().y
							+ impediment.getBounds().height) {
						player.getBounds().width = player.WIDTH_RUN;
						player.getBounds().height = player.HEIGHT_RUN;
						player.getAccelation().y = 0;
						player.getVeloctity().y = 0;
						player.getPosition().y = impediment.getBounds().height
								+ impediment.getPosition().y + 10;
						player.setStateTimeJump1(0);
						player.setColistionState(2);
						impediment.setCollisionPlayer(false);
						((CarLong) impediment).setPlayerRun(true);
//						System.out.println("collistion : " +player.isFlingAuto());
					} else {
						player.setColistionState(1);
						impediment.setCollisionPlayer(false);
					}
				}
			} else {
				if (player.getBounds().overlaps(impediment.getBounds())
						&& impediment.isCollisionPlayer()) {
					player.setColistionState(1);
					impediment.setCollisionPlayer(false);
				}
			}
		}
	}
}
