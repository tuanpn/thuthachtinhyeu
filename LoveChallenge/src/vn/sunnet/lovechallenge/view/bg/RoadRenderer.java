package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.bg.Road;
import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RoadRenderer {

	private TextureRegion roadRegion1;
	private TextureRegion roadRegion2;

	private World world;
	private Road road1;
	private Road road2;

	public RoadRenderer(World world) {
		this.world = world;
		road1 = (Road) world.getBackgrounds().get(2);
		road2 = (Road) world.getBackgrounds().get(3);

		roadRegion1 = Resources.getInstance().roadRegion;

		roadRegion2 = new TextureRegion(roadRegion1);
	}

	public void render(SpriteBatch batch, float delta) {
		batch.draw(roadRegion1, road1.getPosition().x, road1.getPosition().y);
		batch.draw(roadRegion2, road2.getPosition().x, road2.getPosition().y);
	}

}
