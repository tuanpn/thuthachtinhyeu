package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.bg.BackgroundLayer2;
import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * vẽ những nhà nền ở phía sau
 * 
 * @author PhamNgoc
 */
public class HouseBGRenderer {

	private TextureRegion bghouse1;
	private TextureRegion bghouse2;
	
	private World world;
	
	private BackgroundLayer2 bg1;
	private BackgroundLayer2 bg2;

	public HouseBGRenderer(World world) {
		this.world = world;
		bg1 = (BackgroundLayer2) world.getBackgrounds().get(4);
		bg2 = (BackgroundLayer2) world.getBackgrounds().get(5);
		
		bghouse1 = Resources.getInstance().bghouseRegion;

		bghouse2 = new TextureRegion(bghouse1);
	}

	public void render(SpriteBatch batch, float delta) {
		batch.draw(bghouse1, bg1.getPosition().x, bg1.getPosition().y);
		batch.draw(bghouse2, bg2.getPosition().x, bg2.getPosition().y);
	}
}
