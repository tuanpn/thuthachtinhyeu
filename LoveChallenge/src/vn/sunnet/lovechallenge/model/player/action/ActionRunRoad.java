package vn.sunnet.lovechallenge.model.player.action;

import vn.sunnet.lovechallenge.model.player.Player;

public class ActionRunRoad implements PlayerActionState {

	Player player;

	public ActionRunRoad(Player player) {
		this.player = player;
	}

	@Override
	public void flingup() {
		if (player.isFlingUp()) {
			player.getVeloctity().y = player.VELOCITY_Y_JUMP;
			player.getAccelation().y = player.GRAVITY;
			player.setActionState(player.getJumpState1());
			player.getBounds().width = player.WIDTH_JUMP;
			player.getBounds().height = player.HEIGHT_JUMP;
			player.setFlingUp(false);
		}
	}

	@Override
	public void flingdown() {
		if (player.isFlingDown()) {
			player.getBounds().width = player.WIDTH_SIT;
			player.getBounds().height = player.HEIGHT_SIT;
			player.setActionState(player.getSitState());
			player.setFlingDown(false);
		}
	}

	@Override
	public void collistionImpedimet() {
		switch (player.getColistionState()) {
		case 0:

			break;
		case 1:
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
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return 0;
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
