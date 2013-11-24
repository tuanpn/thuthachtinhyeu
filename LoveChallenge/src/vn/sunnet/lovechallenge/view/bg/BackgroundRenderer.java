package vn.sunnet.lovechallenge.view.bg;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundRenderer {

	SkyRenderer skyRenderer;
	RoadRenderer roadRenderer;
	HouseBGRenderer housebg;
	HouseRenderer houseRenderer;

	public BackgroundRenderer() {
		skyRenderer = new SkyRenderer();
		roadRenderer = new RoadRenderer();
		housebg = new HouseBGRenderer();
		houseRenderer = new HouseRenderer();
	}

	public void render(SpriteBatch batch, float delta) {
		skyRenderer.render(batch, delta);
		housebg.render(batch, delta);
		roadRenderer.render(batch, delta);
		houseRenderer.render(batch, delta);
	}

}
