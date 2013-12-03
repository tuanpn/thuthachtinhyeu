package vn.sunnet.lovechallenge.view;

import vn.sunnet.lovechallenge.model.staticobjects.Impediment;
import vn.sunnet.lovechallenge.model.world.World;
import vn.sunnet.lovechallenge.view.bg.BackgroundRenderer;
import vn.sunnet.lovechallenge.view.player.PlayerRenderer;
import vn.sunnet.lovechallenge.view.staticobject.StaticRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector3;

public class WorldRenderer {

	private World world;
	private boolean debug;

	SpriteBatch batcher;
	OrthographicCamera cam;

	BackgroundRenderer bgRenderer;
	PlayerRenderer playerRenderer;
	StaticRenderer staticRenderer;

	private ShaderProgram shader;
	// read our shader files
	String vertexShader;
	String fragmentShader;

	public WorldRenderer(World world, boolean debug) {
		this.world = world;
		this.debug = debug;

		cam = new OrthographicCamera();
		cam.setToOrtho(false, 800, 480);
		cam.position.set(400, 240, 0);
		cam.update();

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(cam.combined);

		bgRenderer = new BackgroundRenderer(world);
		playerRenderer = new PlayerRenderer(world);
		staticRenderer = new StaticRenderer(world);

		vertexShader = Gdx.files.internal("vertexShader.glsl").readString();
		fragmentShader = Gdx.files.internal("vertexShader.glsl").readString();
		shader = new ShaderProgram(vertexShader, fragmentShader);
		shader.begin();
		shader.setUniformi("u_lightmap", 1);
		shader.setUniformf("ambientColor", ambientColor.x, ambientColor.y,
				ambientColor.z, ambientIntensity);
		shader.end();
	}

	public static final float ambientIntensity = .7f;
	public static final Vector3 ambientColor = new Vector3(0.3f, 0.3f, 0.7f);

	public void render(float delta) {
		batcher.setProjectionMatrix(cam.combined);
		cam.update();
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
		renderer.setProjectionMatrix(cam.combined);
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
