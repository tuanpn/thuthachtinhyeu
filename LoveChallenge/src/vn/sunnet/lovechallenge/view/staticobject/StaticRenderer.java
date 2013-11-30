package vn.sunnet.lovechallenge.view.staticobject;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import vn.sunnet.lovechallenge.Resources;
import vn.sunnet.lovechallenge.model.staticobjects.Impediment;
import vn.sunnet.lovechallenge.model.world.World;

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
	Sprite carlong1;
	Sprite carlong2;
	Sprite carlong3;
	Sprite carlong4;

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
		carlong1 = Resources.getInstance().carlong1Sprite;
		carlong1.setScale(1.5f);
		carlong2 = Resources.getInstance().carlong2Sprite;
		carlong2.setScale(1.5f);
		carlong3 = Resources.getInstance().carlong3Sprite;
		carlong3.setScale(1.5f);
		carlong4 = Resources.getInstance().carlong4Sprite;
		carlong4.setScale(1.5f);
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
				box1.setPosition(impedimentar.getPosition().x - 30,
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
			case "carlong1":
				carlong1.setPosition(impedimentar.getPosition().x - 20,
						impedimentar.getPosition().y);
				carlong1.draw(batch);
				break;
			case "carlong2":
				carlong2.setPosition(impedimentar.getPosition().x - 20,
						impedimentar.getPosition().y);
				carlong2.draw(batch);
				break;
			case "carlong3":
				carlong3.setPosition(impedimentar.getPosition().x - 20,
						impedimentar.getPosition().y);
				carlong3.draw(batch);
				break;
			case "carlong4":
				carlong4.setPosition(impedimentar.getPosition().x - 20,
						impedimentar.getPosition().y);
				carlong4.draw(batch);
				break;

			default:
				break;
			}

		}

	}

}
