package vn.sunnet.lovechallenge.view.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.player.action.ActionJump1;
import vn.sunnet.lovechallenge.model.player.action.ActionRunRoad;
import vn.sunnet.lovechallenge.model.player.action.ActionStop;
import vn.sunnet.lovechallenge.model.world.World;
import vn.sunnet.lovechallenge.utils.AnimationCompositeSprite;

public class PlayerRenderer {

	private World world;
	private Player player;

	AnimationCompositeSprite runNomal;
	AnimationCompositeSprite runCry;
	AnimationCompositeSprite jump1;
	AnimationCompositeSprite jump2;
	AnimationCompositeSprite sit;
	AnimationCompositeSprite die1;
	AnimationCompositeSprite die2;

	public PlayerRenderer(World world) {
		this.world = world;
		player = world.getPlayer();

		runNomal = Resources.getInstance().player_run_normal;
		runNomal.setPosition(world.getPlayer().getPosition().x, world
				.getPlayer().getPosition().y);

//		runCry = Resources.getInstance().player_run_cry;
//		runCry.setPosition(world.getPlayer().getPosition().x, world.getPlayer()
//				.getPosition().y);

		jump1 = Resources.getInstance().player_jump_1;
		jump2 = Resources.getInstance().player_jump_2;
		sit = Resources.getInstance().player_sit;

		die1 = Resources.getInstance().player_die_1;
		die1.setPosition(world.getPlayer().getPosition().x, world.getPlayer()
				.getPosition().y);
		die2 = Resources.getInstance().player_die_2;
		die2.setPosition(world.getPlayer().getPosition().x, world.getPlayer()
				.getPosition().y);
	}

	public void render(SpriteBatch batch, float delta) {

		switch (player.getActionState().getID()) {
		case 0:
			runNomal.setPosition(player.getPosition().x, player.getPosition().y);
			runNomal.getKeyFrame(player.getStateTimeRun(), true).draw(batch);
			break;
		case 1:
			switch (player.getTypeJump()) {
			case 1:
				jump1.setPosition(player.getPosition().x,
						player.getPosition().y);
				jump1.getKeyFrame(player.getStateTimeJump1(), false)
						.draw(batch);
				break;
			case 2:
				jump2.setPosition(player.getPosition().x,
						player.getPosition().y);
				jump2.getKeyFrame(player.getStateTimeJump1(), false)
						.draw(batch);
				break;

			default:
				break;
			}

			break;
		case 2:
			sit.setPosition(player.getPosition().x, player.getPosition().y);
			sit.getKeyFrame(player.getStateTimeSit(), true).draw(batch);
			break;
		case 3:
			switch (player.getTypeDie()) {
			case 1:
				die1.getKeyFrame(player.getStateTimeDie(), false).draw(batch);
				break;
			case 2:
				die2.getKeyFrame(player.getStateTimeDie(), false).draw(batch);
				break;

			default:
				break;
			}

			break;
		case 4:
			runNomal.setPosition(player.getPosition().x, player.getPosition().y);
			runNomal.getKeyFrame(player.getStateTimeRunCar(), false)
					.draw(batch);
			break;

		default:
			break;
		}
	}

}
