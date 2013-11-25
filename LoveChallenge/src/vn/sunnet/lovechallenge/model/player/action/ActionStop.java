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
	public void collistionImpedimet(float delta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void idleRun(float delta) {
		player.setTimeDie(player.getTimeDie() + delta);
		if (player.getTimeDie() > 2f) {
			player.setTimeDie(0);
			player.setColistionState(0);
			player.setStateTimeJump1(0);
			player.setActionState(player.getRunState());
			player.getAccelation().y = 0;
			player.getVeloctity().y = 0;
			player.getPosition().y = player.POSITION_INIT_Y;
			player.setStopUpdate(false);
		} 
		if(player.getTimeDie() > 1f) {
			player.setStopUpdate(true);
		}
	}
}
