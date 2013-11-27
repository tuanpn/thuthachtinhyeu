package vn.sunnet.lovechallenge.model.player.action;

import vn.sunnet.lovechallenge.model.player.Player;

public class ActionJump1 implements PlayerActionState {

	Player player;

	public ActionJump1(Player player) {
		this.player = player;
	}

	@Override
	public void flingup() {
		// Hủy chức năng nhảy 2 lần
		// if (player.isFlingUp()) {
		// player.getVeloctity().y += player.VELOCITY_Y_JUMP;
		// player.setFlingUp(false);
		// player.setActionState(player.getJumpState2());
		// }
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
			player.setColistionState(0);
			player.setActionState(player.getRunOnCarState());
			break;

		default:
			break;
		}
	}

	@Override
	public void idleRun(float delta) {
		if (player.getColistionState() == 0) {
			if (player.getPosition().y < player.POSITION_INIT_Y
					&& player.getVeloctity().y < 0) {
				player.resetAll();
			}
		}

	}

	@Override
	public int getID() {
		return 1;
	}

}
