package vn.sunnet.lovechallenge.model.player.action;

import vn.sunnet.lovechallenge.model.player.Player;

public class ActionStop implements PlayerActionState {

	Player player;

	public ActionStop(Player player) {
		this.player = player;
	}

	@Override
	public void flingup() {
		player.setFlingUp(false);
	}

	@Override
	public void flingdown() {
		player.setFlingDown(false);
	}

	@Override
	public void collistionImpedimet() {
		// TODO Auto-generated method stub

	}

	@Override
	public void backRun() {
		if (player.getStateTimeDie() > 2f) {
			player.resetAll();
		} 
		if(player.getStateTimeDie() > 1f) {
			player.setStopUpdate(true);
		}
//		System.out.println("yes");
	}

	@Override
	public int getID() {
		return 3;
	}

	@Override
	public void jumpHighOnCar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jumpAutoCarToRoad() {
		// TODO Auto-generated method stub
		
	}
}
