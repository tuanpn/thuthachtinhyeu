package vn.sunnet.lovechallenge.view.bg;

import vn.sunnet.lovechallenge.Resources;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * vẽ những nhà nền ở phía sau
 * 
 * @author PhamNgoc
 */
public class HouseBGRenderer {

	private Sprite bghouse1;
	private Sprite bghouse2;
	private float width;

	public HouseBGRenderer() {
		bghouse1 = Resources.getInstance().bghouseSprite;
		bghouse1.setPosition(0, 201);
		width = bghouse1.getWidth();
		
		bghouse2 = new Sprite(bghouse1);
		bghouse2.setPosition(bghouse1.getX() + width, bghouse1.getY());
	}

	public void render(SpriteBatch batch, float delta) {
		float deltaX = -100 * delta;
		bghouse1.setX(bghouse1.getX() + deltaX);
		bghouse2.setX(bghouse2.getX() + deltaX);
		
		if (0 > bghouse1.getX() + width) {
			bghouse1.setX(bghouse1.getX() + width + width);
		}

		if (0 > bghouse2.getX() + width) {
			bghouse2.setX(bghouse2.getX() + width + width);
		}

//		if (cam.position.x >= bghouse1.getX() + width + 400) {
//			bghouse1.setX(bghouse1.getX() + width + width);
//		}
//
//		if (cam.position.x >= bghouse2.getX() + width + 400) {
//			bghouse2.setX(bghouse2.getX() + width + width);
//		}

		bghouse1.draw(batch);
		bghouse2.draw(batch);
	}

}
