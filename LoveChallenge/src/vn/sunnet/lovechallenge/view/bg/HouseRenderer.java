package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.controller.LoadMap;
import vn.sunnet.lovechallenge.model.bg.Background;
import vn.sunnet.lovechallenge.model.bg.House;
import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class HouseRenderer {

	private World world;

	private TextureRegion house1Region;
	private TextureRegion house2Region;
	private TextureRegion house3Region;
	private TextureRegion house4Region;
	private TextureRegion house5Region;
	private TextureRegion house6Region;

	House house1;
	House house2;
	House house3;
	House house4;
	House house5;
	House house6;

	public HouseRenderer(World world) {
		this.world = world;

		house1Region = Resources.getInstance().house1Region;
		house2Region = Resources.getInstance().house2Region;
		house3Region = Resources.getInstance().house3Region;
		house4Region = Resources.getInstance().house4Region;
		house5Region = Resources.getInstance().house5Region;
		house6Region = Resources.getInstance().house6Region;

		house1 = (House) world.getBackgrounds().get(6);
		house2 = (House) world.getBackgrounds().get(7);
		house3 = (House) world.getBackgrounds().get(8);
		house4 = (House) world.getBackgrounds().get(9);
		house5 = (House) world.getBackgrounds().get(10);
		house6 = (House) world.getBackgrounds().get(11);
	}

	public void render(SpriteBatch batch, float delta) {
		batch.draw(house1Region, house1.getPosition().x, house1.getPosition().y);
		batch.draw(house2Region, house2.getPosition().x, house2.getPosition().y);
		batch.draw(house3Region, house3.getPosition().x, house3.getPosition().y);
		batch.draw(house4Region, house4.getPosition().x, house4.getPosition().y);
		batch.draw(house5Region, house5.getPosition().x, house5.getPosition().y);
		batch.draw(house6Region, house6.getPosition().x, house6.getPosition().y);
	}

}
