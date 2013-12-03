package vn.sunnet.lovechallenge.view.staticobject;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;
import vn.sunnet.lovechallenge.model.world.World;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class StaticRenderer {

	private World world;

	TextureRegion car1Region;
	TextureRegion car2Region;
	TextureRegion box1Region;
	TextureRegion box2Region;
	TextureRegion static1Region;
	TextureRegion static2Region;
	TextureRegion static3Region;
	TextureRegion static4Region;
	TextureRegion carlong1Region;
	TextureRegion carlong2Region;
	TextureRegion carlong3Region;
	TextureRegion carlong4Region;

	public StaticRenderer(World world) {
		this.world = world;

		car1Region = Resources.getInstance().car1Region;
		car2Region = Resources.getInstance().car2Region;
		box1Region = Resources.getInstance().box1Region;
		box2Region = Resources.getInstance().box2Region;
		static1Region = Resources.getInstance().static1Region;
		static2Region = Resources.getInstance().static2Region;
		static3Region = Resources.getInstance().static3Region;
		static4Region = Resources.getInstance().static4Region;
		carlong1Region = Resources.getInstance().carlong1Region;
		carlong2Region = Resources.getInstance().carlong2Region;
		carlong3Region = Resources.getInstance().carlong3Region;
		carlong4Region = Resources.getInstance().carlong4Region;
	}

	public void render(SpriteBatch batch, float delta) {
		for (Impediment impedimentar : world.getStaticObjects()) {
			switch (impedimentar.getId()) {
			case "cargray":
				batch.draw(car1Region, impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				break;
			case "caryellow":
				batch.draw(car2Region, impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				break;
			case "box1":
				batch.draw(box1Region, impedimentar.getPosition().x - 30,
						impedimentar.getPosition().y);
				break;
			case "box2":
				batch.draw(box2Region, impedimentar.getPosition().x,
						impedimentar.getPosition().y);
				break;
			case "static1":
				batch.draw(static1Region, impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				break;
			case "static2":
				batch.draw(static2Region, impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				break;
			case "static3":
				batch.draw(static3Region, impedimentar.getPosition().x - 10,
						impedimentar.getPosition().y);
				break;
			case "static4":
				batch.draw(static4Region, impedimentar.getPosition().x - 5,
						impedimentar.getPosition().y);
				break;
			case "carlong1":
				batch.draw(carlong1Region, impedimentar.getPosition().x-50,
						impedimentar.getPosition().y-15);
				break;
			case "carlong2":
				batch.draw(carlong2Region, impedimentar.getPosition().x-50,
						impedimentar.getPosition().y-15);
				break;
			case "carlong3":
				batch.draw(carlong3Region, impedimentar.getPosition().x-50,
						impedimentar.getPosition().y-15);
				break;
			case "carlong4":
				batch.draw(carlong4Region, impedimentar.getPosition().x-50,
						impedimentar.getPosition().y-15);
				break;

			default:
				break;
			}

		}

	}

}
