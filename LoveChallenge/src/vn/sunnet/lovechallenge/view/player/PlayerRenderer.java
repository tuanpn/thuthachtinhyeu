package vn.sunnet.lovechallenge.view.player;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.player.action.ActionJump1;
import vn.sunnet.lovechallenge.model.player.action.ActionRun;
import vn.sunnet.lovechallenge.model.player.action.ActionSit;
import vn.sunnet.lovechallenge.model.player.action.ActionStop;
import vn.sunnet.lovechallenge.utils.AnimationSprite;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayerRenderer {

	private World world;
	private Player player;

	AnimationSprite run_body;
	AnimationSprite jump1;
	AnimationSprite sit;
	AnimationSprite diejump;

	public PlayerRenderer(World world) {
		this.world = world;
		player = world.getPlayer();

		run_body = Resources.getInstance().player_run;
		run_body.setPosition(world.getPlayer().getPosition().x, world
				.getPlayer().getPosition().y);

		jump1 = Resources.getInstance().player_jump_1;

		sit = Resources.getInstance().player_sit;
		sit.setPosition(world.getPlayer().getPosition().x, world.getPlayer()
				.getPosition().y);

		diejump = Resources.getInstance().player_die_jump;
		diejump.setPosition(world.getPlayer().getPosition().x, world
				.getPlayer().getPosition().y);
	}

	public void render(SpriteBatch batch, float delta) {
		if (player.getActionState() instanceof ActionRun) {
			run_body.getKeyFrame(player.getStateTimeRun(), true).draw(batch);
		} else if (player.getActionState() instanceof ActionJump1) {
			jump1.setPosition(player.getPosition().x, player.getPosition().y);
			jump1.getKeyFrame(player.getStateTimeJump1(), false).draw(batch);
		} else if (player.getActionState() instanceof ActionSit) {
			sit.getKeyFrame(player.getStateTimeSit(), false).draw(batch);
		} else if (player.getActionState() instanceof ActionStop) {
			diejump.getKeyFrame(player.getTimeDie(), false).draw(batch);
		}

	}

}
