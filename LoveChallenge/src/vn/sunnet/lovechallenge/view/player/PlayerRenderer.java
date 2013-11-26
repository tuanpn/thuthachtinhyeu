package vn.sunnet.lovechallenge.view.player;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.model.player.Player;
import vn.sunnet.lovechallenge.model.player.action.ActionRun;
import vn.sunnet.lovechallenge.model.player.action.ActionStop;
import vn.sunnet.lovechallenge.utils.AnimationCompositeSprite;

public class PlayerRenderer {

	private World world;
	private Player player;

	AnimationCompositeSprite runNomal;
	AnimationCompositeSprite runCry;

	public PlayerRenderer(World world) {
		this.world = world;
		player = world.getPlayer();

		runNomal = Resources.getInstance().player_run_normal;
		runNomal.setPosition(world.getPlayer().getPosition().x, world
				.getPlayer().getPosition().y);
		
		runCry = Resources.getInstance().player_run_cry;
		runCry.setPosition(world.getPlayer().getPosition().x, world
				.getPlayer().getPosition().y);
	}

	public void render(SpriteBatch batch, float delta) {
		if (player.getActionState() instanceof ActionRun) {
			runNomal.getKeyFrame(player.getStateTimeRun(), true).draw(batch);
		} if(player.getActionState() instanceof ActionStop) {
			runCry.getKeyFrame(player.getTimeDie(), true).draw(batch);
		}
	}

}
