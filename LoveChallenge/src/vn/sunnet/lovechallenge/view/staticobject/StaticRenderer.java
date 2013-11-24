package vn.sunnet.lovechallenge.view.staticobject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.World;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;

public class StaticRenderer {

	private World world;

	Sprite car1;
	Sprite car2;

	public StaticRenderer(World world) {
		this.world = world;

		car1 = Resources.getInstance().car1Sprite;
		car2 = Resources.getInstance().car2Sprite;
	}

	public void render(SpriteBatch batch, float delta) {
		for (Impediment impedimentar : world.getStaticObjects()) {
			switch (impedimentar.getId()) {
			case "cargray":
				car1.setPosition(impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				car1.draw(batch);
				break;
			case "caryellow":
				car2.setPosition(impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				car2.draw(batch);
				break;

			default:
				break;
			}

		}

	}

}
