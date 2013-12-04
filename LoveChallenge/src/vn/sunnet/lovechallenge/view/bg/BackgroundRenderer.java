package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundRenderer {

	SkyRenderer skyRenderer;
//	RoadRenderer roadRenderer;
	HouseBGRenderer housebg;
	HouseRenderer houseRenderer;

	public BackgroundRenderer(World world) {
		skyRenderer = new SkyRenderer(world);
//		roadRenderer = new RoadRenderer(world);
		housebg = new HouseBGRenderer(world);
		houseRenderer = new HouseRenderer(world);
	}

	public void render(SpriteBatch batch, float delta) {
		skyRenderer.render(batch, delta);
		housebg.render(batch, delta);
//		roadRenderer.render(batch, delta);
		houseRenderer.render(batch, delta);
	}

}
