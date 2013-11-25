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
				player.getAccelation().y = 0;
				player.getVeloctity().y = 0;
				player.getPosition().y = player.POSITION_INIT_Y;
				player.setStateTimeJump1(0);
				player.setActionState(player.getRunState());
				player.getBounds().width = player.WIDTH_RUN;
				player.getBounds().height = player.HEIGHT_RUN;
			} else {
				player.setStateTimeJump1(player.getStateTimeJump1() + delta);
			}
		}

	}

}
