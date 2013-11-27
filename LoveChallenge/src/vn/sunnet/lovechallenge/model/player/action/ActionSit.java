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
		player.setStateTimeSit(player.getStateTimeSit() + delta);
		if (player.getStateTimeSit() > player.TIME_SIT) {
			player.initStateRun();
		}
	}

	@Override
	public int getID() {
		return 2;
	}

}
