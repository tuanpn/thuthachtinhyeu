package vn.sunnet.lovechallenge.model.player.action;

import vn.sunnet.lovechallenge.model.player.Player;

public class ActionSit implements PlayerActionState {

	Player player;

	public ActionSit(Player player) {
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
		switch (player.getColistionState()) {
		case 0:

			break;
		case 1:
			int type = Math.random() < 0.5f ? 1 : 2;
			player.setTypeDie(type);
			player.setActionState(player.getStopState());
			break;
		case 2:

			break;

		default:
			break;
		}
	}

	@Override
	public void backRun() {
		if (player.getStateTimeSit() > player.TIME_SIT) {
			player.resetAll();
		}
	}

	@Override
	public int getID() {
		return 2;
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
