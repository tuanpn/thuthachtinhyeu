package vn.sunnet.lovechallenge.model.player.action;

import vn.sunnet.lovechallenge.model.player.Player;

public class ActionRun implements PlayerActionState {

	Player player;

	public ActionRun(Player player) {
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
		} else if(player.isFlingDown()) {
			player.getBounds().width = player.WIDTH_SIT;
			player.getBounds().height = player.HEIGHT_SIT;
			player.setActionState(player.getSitState());
			player.setFlingDown(false);
		}
	}

	@Override
	public void flingdown() {

	}

	@Override
	public void collistionImpedimet() {
		
	}

	@Override
	public void idleRun(float delta) {

	}

}
