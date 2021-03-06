package vn.sunnet.lovechallenge.view;

import vn.sunnet.lovechallenge.model.staticobjects.Impediment;
import vn.sunnet.lovechallenge.model.world.World;
import vn.sunnet.lovechallenge.view.bg.BackgroundRenderer;
import vn.sunnet.lovechallenge.view.player.PlayerRenderer;
import vn.sunnet.lovechallenge.view.staticobject.StaticRenderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class WorldRenderer {

	private World world;
	private boolean debug;

	SpriteBatch batcher;

	BackgroundRenderer bgRenderer;
	PlayerRenderer playerRenderer;
	StaticRenderer staticRenderer;

	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.debug = debug;

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(world.cam.combined);

		bgRenderer = new BackgroundRenderer(world);
		playerRenderer = new PlayerRenderer(world);
		staticRenderer = new StaticRenderer(world);
	}

	public static final float ambientIntensity = .7f;
	public static final Vector3 ambientColor = new Vector3(0.3f, 0.3f, 0.7f);

	public void render(float delta) {
		batcher.setProjectionMatrix(world.cam.combined);
		// switch (world.getTypeSky()) {
		// case 1:
		// batcher.setColor(1, 1, 1, 1);
		// break;
		// case 2:
		// batcher.setColor(0.8f, 0.8f, 0.8f, 1);
		// break;
		// case 3:
		// batcher.setColor(0.6f, 0.6f, 0.6f, 1);
		// break;
		// case 4:
		// batcher.setColor(0.4f, 0.4f, 0.4f, 1);
		// break;
		// default:
		// break;
		// }

		batcher.begin();
		bgRenderer.render(batcher, delta);
		staticRenderer.render(batcher, delta);
		playerRenderer.render(batcher, delta);
		batcher.end();
		if (debug)
			drawDebug();
	}

	ShapeRenderer renderer = new ShapeRenderer();

	private void drawDebug() {
		renderer.setProjectionMatrix(world.cam.combined);
		renderer.begin(ShapeType.Line);
		renderer.setColor(Color.GREEN);
		renderer.rect(world.getPlayer().getBounds().x, world.getPlayer()
				.getBounds().y, world.getPlayer().getBounds().width, world
				.getPlayer().getBounds().height);
		renderer.end();

		renderer.begin(ShapeType.Line);
		for (Impediment staticObject : world.getStaticObjects()) {
			renderer.setColor(Color.PINK);
			renderer.rect(staticObject.getBounds().x,
					staticObject.getBounds().y, staticObject.getBounds().width,
					staticObject.getBounds().height);
		}
		renderer.end();
	}

}
