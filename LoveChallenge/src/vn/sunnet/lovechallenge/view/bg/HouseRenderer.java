package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.bg.House;
import vn.sunnet.lovechallenge.model.bg.Lamppost;
import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class HouseRenderer {

	private World world;

	private TextureRegion neighborhoodRegion;
	private TextureRegion lamppostRegion;

	House house1;
	House house2;

	// lamppost
	Lamppost lamppost1;
	Lamppost lamppost2;
	Lamppost lamppost3;
	Lamppost lamppost4;
	Lamppost lamppost5;
	Lamppost lamppost6;

	public HouseRenderer(World world) {
		this.world = world;

		neighborhoodRegion = Resources.getInstance().neighborhoodRegion;
		lamppostRegion = Resources.getInstance().lamppostRegion;

		house1 = (House) world.getBackgrounds().get(6);
		house2 = (House) world.getBackgrounds().get(7);

		lamppost1 = (Lamppost) world.getBackgrounds().get(8);
		lamppost2 = (Lamppost) world.getBackgrounds().get(9);
		lamppost3 = (Lamppost) world.getBackgrounds().get(10);
		lamppost4 = (Lamppost) world.getBackgrounds().get(11);
		lamppost5 = (Lamppost) world.getBackgrounds().get(12);
		lamppost6 = (Lamppost) world.getBackgrounds().get(13);
	}

	public void render(SpriteBatch batch, float delta) {
		batch.draw(neighborhoodRegion, house1.getPosition().x,
				house1.getPosition().y);
		batch.draw(neighborhoodRegion, house2.getPosition().x,
				house2.getPosition().y);
		// lamppost
		batch.draw(lamppostRegion, lamppost1.getPosition().x,
				lamppost1.getPosition().y);
		batch.draw(lamppostRegion, lamppost2.getPosition().x,
				lamppost2.getPosition().y);
		batch.draw(lamppostRegion, lamppost3.getPosition().x,
				lamppost3.getPosition().y);
		batch.draw(lamppostRegion, lamppost4.getPosition().x,
				lamppost4.getPosition().y);
		batch.draw(lamppostRegion, lamppost5.getPosition().x,
				lamppost5.getPosition().y);
		batch.draw(lamppostRegion, lamppost6.getPosition().x,
				lamppost6.getPosition().y);
	}

}
