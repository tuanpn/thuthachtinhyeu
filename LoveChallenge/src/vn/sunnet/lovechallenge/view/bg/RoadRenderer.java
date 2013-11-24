package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RoadRenderer {

	private Sprite roadSprite1;
	private Sprite roadSprite2;
	private float width;

	boolean check = true;

	public RoadRenderer() {
		roadSprite1 = Resources.getInstance().roadSprite;
		width = roadSprite1.getWidth();

		roadSprite2 = new Sprite(roadSprite1);
		roadSprite2.setPosition(roadSprite1.getY() + width, roadSprite1.getY());
	}

	public void render(SpriteBatch batch, float delta) {
		float deltaX = -300 * delta;
		roadSprite1.setX(roadSprite1.getX() + deltaX);

		if (0 > roadSprite1.getX() + width) {
			roadSprite1.setX(roadSprite1.getX() + width + width);
			check = false;
		}

		if (0 > roadSprite2.getX() + width) {
			check = true;
		}

		if (check) {
			roadSprite2.setX(roadSprite1.getX() + width);
		} else {
			roadSprite2.setX(roadSprite1.getX() - width);
		}

		roadSprite1.draw(batch);
		roadSprite2.draw(batch);
	}

}
