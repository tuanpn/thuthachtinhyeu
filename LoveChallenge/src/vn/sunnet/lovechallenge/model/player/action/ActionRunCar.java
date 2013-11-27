package vn.sunnet.lovechallenge.model.player.action;

import vn.sunnet.lovechallenge.model.player.Player;

public class ActionRunCar implements PlayerActionState {

	Player player;

	public ActionRunCar(Player player) {
		this.player = player;
	}

	@Override
	public void flingup() {
		
		if (player.isFlingUp()) {
			player.getVeloctity().y = 200;
			player.getAccelation().y = player.GRAVITY;
			player.setActionState(player.getJumpState1());
			player.getBounds().width = player.WIDTH_JUMP;
			player.getBounds().height = player.HEIGHT_JUMP;
			player.setFlingUp(false);
			
		} else if (player.isFlingDown()) {
			player.getBounds().width = player.WIDTH_SIT;
			player.getBounds().height = player.HEIGHT_SIT;
			player.setActionState(player.getSitState());
			player.setFlingDown(false);
		}
		
	}

	@Override
	public void flingdown() {
		// TODO Auto-generated method stub

	}

	@Override
	public void collistionImpedimet(float delta) {
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
	public void idleRun(float delta) {
	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 4;
	}

}
