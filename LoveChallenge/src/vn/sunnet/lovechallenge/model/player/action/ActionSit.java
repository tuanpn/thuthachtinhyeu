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
		// TODO Auto-generated method stub

	}

	@Override
	public void idleRun(float delta) {
		player.setStateTimeSit(player.getStateTimeSit() + delta);
		if (player.getStateTimeSit() > player.TIME_SIT) {
			player.setStateTimeSit(0);
			player.getBounds().width = player.WIDTH_RUN;
			player.getBounds().height = player.HEIGHT_RUN;
			player.setActionState(player.getRunState());
		}
	}

}
