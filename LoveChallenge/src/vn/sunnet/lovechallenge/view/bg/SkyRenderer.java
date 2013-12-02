package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.bg.Sky;
import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Vẽ bầu trời phía sau cùng
 * 
 * @author PhamNgoc
 * 
 */
public class SkyRenderer {

	private TextureRegion sky1Region1;
	private TextureRegion sky1Region2;

	private TextureRegion sky2Region1;

	private TextureRegion sky3Region1;
	private TextureRegion sky3Region2;

	private TextureRegion sky4Region1;

	private TextureRegion sky5Region1;
	private TextureRegion sky5Region2;

	private TextureRegion sky6Region1;

	private float width;

	// biến cờ
	boolean check = true;

	private World world;
	private Sky sky1;
	private Sky sky2;

	public SkyRenderer(World world) {
		this.world = world;

		sky1 = (Sky) world.getBackgrounds().get(0);
		sky2 = (Sky) world.getBackgrounds().get(1);

		// region
		sky1Region1 = Resources.getInstance().sky1Region;
		sky1Region2 = new TextureRegion(sky1Region1);

		sky2Region1 = Resources.getInstance().sky2Region;
		
		sky3Region1 = Resources.getInstance().sky3Region;
		sky3Region2 = new TextureRegion(sky3Region1);
	}

	public void render(SpriteBatch batch, float delta) {

		switch (world.getTypeSky()) {
		case 0:
			batch.draw(sky1Region1, sky1.getPosition().x, sky1.getPosition().y);
			batch.draw(sky1Region2, sky2.getPosition().x, sky2.getPosition().y);
			break;
		case 1:
			batch.draw(sky2Region1, sky1.getPosition().x, sky1.getPosition().y);
			batch.draw(sky3Region1, sky2.getPosition().x, sky2.getPosition().y);
			break;
		case 2:
			batch.draw(sky3Region1, sky1.getPosition().x, sky1.getPosition().y);
			batch.draw(sky3Region2, sky2.getPosition().x, sky2.getPosition().y);
			break;

		default:
			break;
		}
	}

}
