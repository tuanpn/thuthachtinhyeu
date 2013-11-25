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
	Sprite box1;
	Sprite box2;
	Sprite static1;
	Sprite static2;
	Sprite static3;
	Sprite static4;

	public StaticRenderer(World world) {
		this.world = world;

		car1 = Resources.getInstance().car1Sprite;
		car2 = Resources.getInstance().car2Sprite;
		box1 = Resources.getInstance().box1Sprite;
		box1.setSize(250, 180);
		box2 = Resources.getInstance().box2Sprite;
		box2.setSize(200, 150);
		static1 = Resources.getInstance().static1Sprite;
		static2 = Resources.getInstance().static2Sprite;
		static3 = Resources.getInstance().static3Sprite;
		static4 = Resources.getInstance().static4Sprite;
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
			case "box1":
				box1.setPosition(impedimentar.getPosition().x-30,
						impedimentar.getPosition().y);
				box1.draw(batch);
				break;
			case "box2":
				box2.setPosition(impedimentar.getPosition().x,
						impedimentar.getPosition().y);
				box2.draw(batch);
				break;
			case "static1":
				static1.setPosition(impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				static1.draw(batch);
				break;
			case "static2":
				static2.setPosition(impedimentar.getPosition().x - 50,
						impedimentar.getPosition().y);
				static2.draw(batch);
				break;
			case "static3":
				static3.setPosition(impedimentar.getPosition().x - 10,
						impedimentar.getPosition().y);
				static3.draw(batch);
				break;
			case "static4":
				static4.setPosition(impedimentar.getPosition().x - 5,
						impedimentar.getPosition().y);
				static4.draw(batch);
				break;

			default:
				break;
			}

		}

	}

}
